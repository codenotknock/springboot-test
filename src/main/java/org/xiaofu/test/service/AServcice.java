package org.xiaofu.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaofu.test.config.AConfig;
import org.xiaofu.test.config.BConfig;
import org.xiaofu.test.dto.AClassDTO;

/**
 * @author xiaofu
 * @date 2024/07/14
 * @program springboot-test
 * @description 模拟实际项目（负责调用）
 **/

@Service
public class AServcice {
    private String name;
    private BServcice bServcice;
    private BConfig bconfig;

    @Autowired
    public AServcice(BServcice bServcice, BConfig bconfig) {
        this.bServcice = bServcice;
        this.bconfig = bconfig;
    }

    public AServcice(String name) {
        this.name = name;
    }

    public AClassDTO getAClassDTO(String name, int age) {
        // 模拟静态变量+静态方法的获取
        String type = BServcice.aConfig.getType(name);
        System.out.println(type);
        if ("testB".equals(bconfig.getType())) {
            AClassDTO aClassDTO = AClassDTO.builder(name, age);
            String staticName = AClassDTO.staticBuilder(name);
            System.out.println(aClassDTO);
            System.out.println(staticName);
        } else {
            AClassDTO aClassDTO = AClassDTO.builder(name, age);
            System.out.println(aClassDTO);
        }

        String bName = bServcice.getName(name);
        System.out.println(bName);

        String name1 = BServcice.getName();
        System.out.println(name1);
        return AClassDTO.builder(name, age);
    }
}
