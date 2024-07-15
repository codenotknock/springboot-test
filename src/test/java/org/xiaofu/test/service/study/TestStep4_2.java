package org.xiaofu.test.service.study;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xiaofu.test.study.ConstructDTO;
import org.xiaofu.test.study.DependencyService1;
import org.xiaofu.test.study.DependencyService2;
import org.xiaofu.test.study.DependencyService3;
import org.xiaofu.test.study.TestService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TestService.class, ConstructDTO.class})
public class TestStep4_2 {

    @Mock
    private DependencyService1 dependencyService1;

    @Spy
    private DependencyService2 dependencyService2 = new DependencyService2();

    @InjectMocks
    @Spy
    private TestService testService;

    @Mock
    private DependencyService3 dependencyService3;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testService.setDependencyService3(dependencyService3);
    }

    @Test
    public void test() throws Exception {
        // 1. 模拟 final 方法
        when(testService.getFinal("1")).thenReturn("1");
        assertEquals("1", testService.getFinal("1"));

        // 2. 模拟私有方法
        PowerMockito.spy(testService);
        PowerMockito.doReturn("2").when(testService, "getPrivate", "2");
        assertEquals("2", PowerMockito.method(TestService.class, "getPrivate").invoke(testService, "2"));

        // 3. 模拟构造方法
        ConstructDTO constructDTO = PowerMockito.mock(ConstructDTO.class);
        PowerMockito.whenNew(ConstructDTO.class).withNoArguments().thenReturn(constructDTO);
        PowerMockito.whenNew(ConstructDTO.class).withArguments("333").thenReturn(constructDTO);
        assertNotNull(new ConstructDTO());
        assertNotNull(new ConstructDTO("333"));

        // 4. 模拟静态方法
        PowerMockito.mockStatic(TestService.class);
        when(TestService.getStatic("444")).thenReturn("4");
        assertEquals("4", TestService.getStatic("444"));
    }
}