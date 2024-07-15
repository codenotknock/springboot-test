//package org.xiaofu.test.service.study;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.MockitoAnnotations;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.reflect.Whitebox;
//import org.xiaofu.test.study.ConstructDTO;
//import org.xiaofu.test.study.DependencyService1;
//import org.xiaofu.test.study.DependencyService2;
//import org.xiaofu.test.study.DependencyService3;
//import org.xiaofu.test.study.TestService;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//
//import com.alibaba.fastjson.JSON;
//
//
//
//@ExtendWith(MockitoExtension.class)
//@PrepareForTest({TestService.class, ConstructDTO.class})
//public class TestStep7 {
//
//    @Mock
//    private DependencyService1 dependencyService1;
//
//    @Spy
//    private DependencyService2 dependencyService2 = new DependencyService2();
//
//    @InjectMocks
//    @Spy
//    private TestService testService;
//
//    @Mock
//    private DependencyService3 dependencyService3;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        testService.setDependencyService3(dependencyService3);
//    }
//
//    @Test
//    void test() throws Exception {
//        String name = "xiaofu";
//        Double accountAmount = 1111.0;
//        Long[] userIds = {1L, 2L, 3L};
//        List<Long> userIdList = Arrays.asList(1L, 2L, 3L);
//        List<UserDO> expectedUserList = Arrays.asList(new UserDO(1L, "User1"), new UserDO(2L, "User2"));
//        List<UserDO> actualUserList = Arrays.asList(new UserDO(1L, "User1"), new UserDO(2L, "User2"));
//
//        // 1.验证简单数据对象
//        assertNotEquals("用户名称不一致", "admin", name);
//        assertEquals("账户金额不一致", 10000.0D, accountAmount, 1E-6D);
//
//        // 2.验证简单数组或集合对象
//        assertArrayEquals("用户标识列表不一致", new Long[]{1L, 2L, 3L}, userIds);
//        assertEquals("用户标识列表不一致", Arrays.asList(1L, 2L, 3L), userIdList);
//
//        // 3.验证复杂数据对象
//        assertEquals("用户标识不一致", Optional.of(1L), Optional.of(1L));
//        assertEquals("用户名称不一致", "xiaofu", name);
//
//        // 4.验证复杂数组或集合对象
//        assertEquals("用户列表长度不一致", expectedUserList.size(), actualUserList.size());
//        UserDO[] expectedUsers = expectedUserList.toArray(new UserDO[0]);
//        UserDO[] actualUsers = actualUserList.toArray(new UserDO[0]);
//        for (int i = 0; i < actualUsers.length; i++) {
//            assertEquals(String.format("用户(%s)标识不一致", i), expectedUsers[i].getId(), actualUsers[i].getId());
//            assertEquals(String.format("用户(%s)名称不一致", i), expectedUsers[i].getName(), actualUsers[i].getName());
//        }
//
//        // 5.通过序列化验证数据对象
//        String text = ResourceHelper.getResourceAsString(getClass(), "userlist.json");
//        assertEquals("用户列表不一致", text, JSON.toJSONString(actualUserList));
//
//        // 6.验证数据对象私有属性字段
//        assertEquals("基础包不一致", "com.alibaba.example", Whitebox.getInternalState(testService, "basePackage"));
//    }
//
//    @Test
//    void testException() {
//        Exception exception = assertThrows(RuntimeException.class, () -> {
//            // Simulate a method that throws an exception
//            throw new RuntimeException("This is a test exception");
//        });
//        assertEquals("This is a test exception", exception.getMessage());
//    }
//
//    @Test
//    void testDependencyService1Interaction() {
//        String input = "test";
//        Mockito.when(dependencyService1.process(input)).thenReturn("processed");
//
//        String result = testService.processInput(input);
//
//        assertEquals("processed", result);
//        Mockito.verify(dependencyService1, times(1)).process(input);
//    }
//}
//
//// Define UserDO class for testing
//class UserDO {
//    private Long id;
//    private String name;
//
//    public UserDO(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
