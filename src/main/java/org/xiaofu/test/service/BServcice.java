package org.xiaofu.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaofu.test.config.AConfig;

/**
 * @author xiaofu
 * @date 2024/07/14
 * @program springboot-test
 * @description 模拟服务
 **/
@Service
public class BServcice {

    public static AConfig aConfig;

    @Autowired
    public void setType(AConfig aConfig) {
        BServcice.aConfig = aConfig;
    }

    public String getName(String name) {
        return "BServcice：" + name;
    }

}
