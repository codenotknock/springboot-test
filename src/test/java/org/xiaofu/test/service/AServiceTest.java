package org.xiaofu.test.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.xiaofu.test.config.AConfig;
import org.xiaofu.test.config.BConfig;
import org.xiaofu.test.dto.AClassDTO;


@ExtendWith(MockitoExtension.class)
class AServiceTest {

    @Mock
    private BServcice bServcice;

    @Mock
    private BConfig bconfig;

    @Mock
    private AConfig aConfig;

    @InjectMocks
    private AServcice aService;

    @BeforeEach
    public void setUp() {
        // 初始化静态变量
        BServcice.aConfig = aConfig;
    }

    @Test
    public void testGetAClassDTO_TypeIsTestB() {
        // 模拟返回值
        when(bconfig.getType()).thenReturn("testB");
        when(bServcice.getName(anyString())).thenReturn("BServcice: mockName");
        when(aConfig.getType(anyString())).thenReturn("mockType");

        AClassDTO result = aService.getAClassDTO("testName", 25);

        assertNotNull(result);
        assertEquals("testName", result.getName());
        assertEquals(25, result.getAge());

        // 验证调用
        verify(bconfig, times(1)).getType();
        verify(bServcice, times(1)).getName("testName");
        verify(aConfig, times(1)).getType("testName");
    }

    @Test
    public void testGetAClassDTO_TypeIsNotTestB() {
        // 模拟返回值
        when(bconfig.getType()).thenReturn("notTestB");
        when(bServcice.getName(anyString())).thenReturn("BServcice: mockName");
        when(aConfig.getType(anyString())).thenReturn("mockType");

        AClassDTO result = aService.getAClassDTO("testName", 25);

        assertNotNull(result);
        assertEquals("testName", result.getName());
        assertEquals(25, result.getAge());

        // 验证调用
        verify(bconfig, times(1)).getType();
        verify(bServcice, times(1)).getName("testName");
        verify(aConfig, times(1)).getType("testName");
    }
}

