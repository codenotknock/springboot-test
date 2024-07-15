package org.xiaofu.test.service.study;

import jdk.jfr.internal.test.WhiteBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 五、调用被测的方法
 **/
@ExtendWith({MockitoExtension.class})
@PrepareForTest({TestService.class, ConstructDTO.class})
public class TestStep5 {



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
        // 1. 调用构造方法
        ConstructDTO constructDTO1 = new ConstructDTO();
        ConstructDTO constructDTO2 = new ConstructDTO("123");
        // 私有 找不到方法
//        WhiteBox.

        // 2. 调用普通方法
        testService.testParam("222");
        // 私有 找不到方法
//        WhiteBox.

        // 3. 调用静态方法
        TestService.getStatic("33333");
        // 私有 找不到方法
//        WhiteBox.
    }

}
