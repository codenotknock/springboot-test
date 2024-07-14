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
public class AConfig {

    private static final String DEFAULT = "default";

    @Value("#{${common.type: testA}}")
    private String type;

    /**
     * 随便模拟的
     *
     * @param name
     * @return
     */
    public String getType(String name) {
        return name + " " + type;
    }
}
