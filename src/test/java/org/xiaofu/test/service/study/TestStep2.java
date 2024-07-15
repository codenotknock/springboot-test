package org.xiaofu.test.service.study;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xiaofu.test.study.DependencyService1;
import org.xiaofu.test.study.DependencyService2;
import org.xiaofu.test.study.TestService;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 二、模拟依赖对象
 **/
@ExtendWith(MockitoExtension.class)
public class TestStep2 {
    // 1. 直接构建对象
    private DependencyService1 dependencyService11 = new DependencyService1();
    private DependencyService2 dependencyService21 = new DependencyService2();

    // 2. 利用 mock 方法或注解
    private DependencyService1 dependencyService12 = Mockito.mock(DependencyService1.class);
    private DependencyService2 dependencyService22 = Mockito.mock(DependencyService2.class);
    @Mock
    private DependencyService1 dependencyService122;
    @Mock
    private DependencyService2 dependencyService222;

    // 2. 利用 spy 方法或注解
    private DependencyService1 dependencyService13 = Mockito.spy(DependencyService1.class);
    private DependencyService2 dependencyService23 = Mockito.spy(DependencyService2.class);
    @Spy // 必须初始化
    private DependencyService1 dependencyService133 = new DependencyService1();
    @Spy  // 必须初始化
    private DependencyService2 dependencyService233 = new DependencyService2();



}
