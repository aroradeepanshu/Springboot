//package com.example.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.demo.dao.UserDao;
//import com.example.demo.entity.User;
//import com.example.demo.service.UserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class CrudAppApplicationTests {
//
//	@Autowired
//	private UserService userService;
//	
//	@MockBean
//	private UserDao userDao;
//	
//	@Test
//	public void getUsersTest() {
//		when(userDao.findAll()).thenReturn(Stream
//				.of(new User("Mohan" , 34 , "male" , "user"),new User("Simran" , 24 , "female" , "user")).collect(Collectors.toList()));
//		assertEquals(2, userService.getUsers().getUserList().size());
//	}
//	
//	@Test
//	public void createUserTest() {
//		Map reqObj = new LinkedHashMap<>();
//		reqObj.put("name", "Mohan");
//		reqObj.put("age", 34);
//		reqObj.put("gender", "male");
//		reqObj.put("type", "user");
//		
//		User user = new User("Mohan" , 34 , "male" , "user");
//		when(userDao.save(user)).thenReturn(user);
//		assertEquals(user.getId(), userService.createUser(reqObj).getUser().getId());
//		assertEquals(user.getName(), userService.createUser(reqObj).getUser().getName());
//		assertEquals(user.getGender(), userService.createUser(reqObj).getUser().getGender());
//		assertEquals(user.getType(), userService.createUser(reqObj).getUser().getType());
//	}
//	
//	@Test
//	public void getUserByIdTest() {
//		int id = 0;
//		User user = new User("Mohan" , 34 , "male" , "user");
//		when(userDao.findById(id)).thenReturn(Optional.ofNullable(user));
//		assertEquals(id , userService.getUserById(id).getUser().getId());
//	}
//
//}
