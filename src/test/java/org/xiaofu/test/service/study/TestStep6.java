package org.xiaofu.test.service.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.xiaofu.test.study.ConstructDTO;
import org.xiaofu.test.study.DependencyService1;
import org.xiaofu.test.study.DependencyService2;
import org.xiaofu.test.study.DependencyService3;
import org.xiaofu.test.study.TestService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 六、验证
 * 根据参数验证、验证调用次数、验证方法调用并捕获参数、验证其它特殊方法
 **/
@ExtendWith({MockitoExtension.class})
@PrepareForTest({TestService.class, ConstructDTO.class})
public class TestStep6 {



    @Mock
    private DependencyService1 dependencyService1;
    @Spy
    private DependencyService2 dependencyService2 = new DependencyService2();
    // 利用 InjectMocks注解，会自动注入mock 或 spy依赖：注意：构造方法的限制
    @InjectMocks
    @Spy
    private TestService testService;



    @Mock
    private DependencyService3 dependencyService3;
    @BeforeEach
    public void setUp() {
        // 初始化mocks
        MockitoAnnotations.initMocks(this);
        testService.setDependencyService3(dependencyService3);
    }

    @Test
    void test() throws Exception {
        ConstructDTO constructDTO = Mockito.mock(ConstructDTO.class);
        // 3. 验证方法调用并捕获参数
        // 3.1 方法定义参数捕获器
        ArgumentCaptor<ConstructDTO> constructDTOArgumentCaptor = ArgumentCaptor.forClass(ConstructDTO.class);
        Mockito.verify(constructDTO).modify(constructDTOArgumentCaptor.capture().toString());
        ConstructDTO constructDTO1 = constructDTOArgumentCaptor.getValue();
        // 3.3 捕获多次方法调用的参数值列表
        ArgumentCaptor<ConstructDTO> argumentCaptor = ArgumentCaptor.forClass(ConstructDTO.class);
        Mockito.verify(constructDTO, Mockito.atLeastOnce()).modify(argumentCaptor.capture().toString());
        List<ConstructDTO> constructDTOList = argumentCaptor.getAllValues();

    }
    // 3.2 使用 @Captor注解定义参数捕获器
    @Captor
    private ArgumentCaptor<ConstructDTO> constructDTOArgumentCaptor;

    @Test
    void test2() throws Exception {
        ConstructDTO constructDTO = Mockito.mock(ConstructDTO.class);
        // 4. 验证特殊方法
        // 4.1 final 方法和普通方法类似

        // 4.2 验证私有方法调用
        PowerMockito.verifyPrivate(TestService.class, times(1)).invoke("getStatic", anyString());

        // 4.3 验证构造方法调用
        PowerMockito.verifyNew(TestService.class).withNoArguments();
        PowerMockito.verifyNew(TestService.class).withArguments("a", "b");

        // 4.4 验证静态方法调用
        PowerMockito.verifyStatic(TestService.class);
    }

}
