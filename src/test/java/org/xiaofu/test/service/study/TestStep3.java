package org.xiaofu.test.service.study;

import jdk.jfr.internal.test.WhiteBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xiaofu.test.study.DependencyService1;
import org.xiaofu.test.study.DependencyService2;
import org.xiaofu.test.study.DependencyService3;
import org.xiaofu.test.study.TestService;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 三、注入依赖对象
 **/
@ExtendWith(MockitoExtension.class)
public class TestStep3 {



    @Mock
    private DependencyService1 dependencyService1;
    @Spy
    private DependencyService2 dependencyService2 = new DependencyService2();
    // 1. 利用 InjectMocks注解，会自动注入mock 或 spy依赖：注意：构造方法的限制
    @InjectMocks
    private TestService testService1 = new TestService();


    @Mock
    private DependencyService3 dependencyService3;
    @BeforeEach
    public void setUp() {
        // 初始化mocks
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void test1() {
        // 2.利用setter 方法注入
        testService1.setDependencyService3(dependencyService3);


        System.out.println(123);
    }

}
