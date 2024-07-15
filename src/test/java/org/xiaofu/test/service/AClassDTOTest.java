package org.xiaofu.test.service;

import org.junit.jupiter.api.Test;
import org.xiaofu.test.dto.AClassDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author xiaofu
 * @date 2024/07/15
 * @program springboot-test
 * @description 静态方法测试
 **/

public class AClassDTOTest {

    @Test
    public void testBuilder() {
        AClassDTO aClassDTO = AClassDTO.builder("testName", 25);
        assertNotNull(aClassDTO);
        assertEquals("testName", aClassDTO.getName());
        assertEquals(25, aClassDTO.getAge());
    }

    @Test
    public void testStaticBuilder() {
        String staticName = AClassDTO.staticBuilder("testName");
        assertNotNull(staticName);
        assertEquals("static testName", staticName);
    }
}
