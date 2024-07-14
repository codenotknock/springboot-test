package org.xiaofu.test.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofu
 * @date 2024/07/14
 * @program springboot-test
 * @description 配置
 **/
@Data
@Configuration
public class BConfig {


    @Value("${common.type: testB}")
    private String type;
}
