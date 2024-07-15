package org.xiaofu.test.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 定义服务：单元测试学习
 **/

@Service
public class TestService {
    @Autowired
    private DependencyService1 dependencyService1;

    @Autowired
    private DependencyService2 dependencyService2;

    private DependencyService3 dependencyService3;

    public void setDependencyService3 (DependencyService3 dependencyService3) {
        this.dependencyService3 = this.dependencyService3;
    }

    /**
     * 无返回值
     * @param one
     */
    public void testVoid(String one) {
        System.out.println(one);
    }

    /**
     * 有返回值
     * @param two
     */
    public String testParam(String two) {
        System.out.println(two);
        return two;
    }

    /**
     * 有返回值且抛出异常
     * @param three
     */
    public String testException (String three) throws Exception{
        System.out.println(three);
        return three;
    }

    /**
     * 有返回值且抛出异常
     * @param four
     */
    public String testExcept (String four){
        System.out.println(four);
        return four;
    }


    /**
     * final 方法
     * @param name
     * @return
     */
    public final String getFinal(String name) {
        return name;
    }

    /**
     * 私有 方法
     * @param name
     * @return
     */
    private String getPrivate(String name) {
        return name;
    }

    /**
     * 静态 方法
     * @param name
     * @return
     */
    public static String getStatic(String name) {
        return name;
    }


}
