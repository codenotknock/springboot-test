package org.xiaofu.test.service.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xiaofu.test.study.DependencyService1;
import org.xiaofu.test.study.DependencyService2;
import org.xiaofu.test.study.DependencyService3;
import org.xiaofu.test.study.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 四、模拟依赖方法:根据返回模拟方法
 **/
@ExtendWith(MockitoExtension.class)
public class TestStep4 {



    @Mock
    private DependencyService1 dependencyService1;
    @Spy
    private DependencyService2 dependencyService2 = new DependencyService2();
    // 利用 InjectMocks注解，会自动注入mock 或 spy依赖：注意：构造方法的限制
    @InjectMocks
    @Spy
    private TestService testService = new TestService();


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
        // 1. 模拟无返回值
        //Mockito.doNothing().when(testService).testVoid("1");

        // 2. 模拟方法单个返回值
        //Mockito.doReturn("2").when(testService).testParam("2");
        //when(testService.testParam("2")).thenReturn("2");

        // 3. 模拟多个返回值
        //Mockito.doReturn("3", "33", "333").when(testService).testParam("2");
        //when(testService.testParam("3")).thenReturn("3", "33", "333");

        // 4. 模拟方法定制返回值
        when(testService.testExcept("special")).thenAnswer(invocation -> {
            String arg = invocation.getArgument(0);
            if ("special".equals(arg)) {
                return "specialValue";
            }
            return null;
        });

        // 5. 模拟方法抛出异常
//        doThrow：用于模拟void方法或者需要抛出异常的方法。
//        thenThrow：用于模拟返回值的方法抛出异常，这里用doThrow更合适。
        Mockito.doThrow(new Exception("5"), new Exception("55")).when(testService).testException(anyString());
//        when(testService.testException(anyString())).thenThrow(new Exception("5"), new Exception("55")).thenReturn(null);

        // 6. 真实方法的调用
        Mockito.doCallRealMethod().when(testService).testParam(anyString());
        //when(testService.testParam("6")).thenCallRealMethod();


        // 验证模拟和真实方法调用的行为
        assertEquals("2", testService.testParam("2"));
        assertEquals("3", testService.testParam("3"));
        assertEquals("specialValue", testService.testExcept("special"));
        assertEquals("6", testService.testParam("6"));  // 真实方法调用

        // 测试异常抛出
        Exception exception1 = assertThrows(Exception.class, () -> {
            testService.testException("test");
        });
        assertEquals("5", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            testService.testException("test");
        });
        assertEquals("55", exception2.getMessage());
    }

}
