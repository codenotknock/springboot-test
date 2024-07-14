package org.xiaofu.test.dto;

import lombok.Data;

/**
 * @author xiaofu
 * @date 2024/07/14
 * @program springboot-test
 * @description AClassDTO
 **/

@Data
public class AClassDTO {

    private String name;

    private int age;


    /**
     * 模拟静态方法
     * @param name
     * @param age
     * @return
     */

    public static AClassDTO builder(String name, int age) {
        AClassDTO aClassDTO = new AClassDTO();
        aClassDTO.setAge(age);
        aClassDTO.setName(name);

        return aClassDTO;
    }

    /**
     * 模拟 final + 静态 方法
     * @param name
     * @return
     */
    public static final String staticBuilder(String name) {
        return "static " + name;
    }
}
