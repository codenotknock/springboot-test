package org.xiaofu.test.study;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description todo desc...
 **/

public class ConstructDTO{

    /**
     * 构造方法
     */
    public ConstructDTO() {}
    public ConstructDTO(String name) {
        System.out.println("construct " + name);
    }
    public ConstructDTO(String name, String me) {
        System.out.println("private construct " + name);
    }

    public String modify(String name) {
        return name;
    }


}
