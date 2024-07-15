package org.xiaofu.test.service.study;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xiaofu.test.study.TestService;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 一、定义测试对象
 **/
@ExtendWith(MockitoExtension.class)
public class TestStep1 {
    // 1. 直接构建对象
    private TestService testService1 = new TestService();

    // 2. 利用 spy 方法或注解
    private TestService testService2 = Mockito.spy(TestService.class);
    @Spy
    private TestService testService22;

    // 3. 利用 InjectMocks注解，且会自动注入其它依赖
    @InjectMocks
    private TestService testService3;


}
