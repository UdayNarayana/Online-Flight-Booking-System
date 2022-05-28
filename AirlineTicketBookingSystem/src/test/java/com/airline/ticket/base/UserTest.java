package com.airline.ticket.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.airline.ticket.base.Repository.UserRepo;
import com.airline.ticket.base.Service.UserService;

@SpringBootTest
public class UserTest {
	@MockBean
	private UserRepo repository;
	@Autowired
	private UserService service;

//	@Test
//	void addUser() {
//		User user = new User(12, "rashi", "rashi124", "rashika", "ka", "user", "user123@gmail.com", 18, 766532241,
//				"dfsyjhb fvghjc");
//		when(repository.save(user)).thenReturn(user);
//		assertEquals(user, service.addUser(user));
//	}

//	@Test
//	public void fetchUserById() {
//		int userId = 30;
//		Optional<User> u = Optional.ofNullable(new User(12, "rashi", "rashi124", "rashika", "ka", "user",
//				"user123@gmail.com", 18, 766532241, "asdfghjkl op"));
//		when(repository.findById(userId)).thenReturn(Optional.ofNullable(new User(12, "rashi", "rashi124", "rashika",
//				"ka", "user", "user123@gmail.com", 21, 766532241, "asdfghjkl op")));
//		assertEquals(u.get().getUserId(), service.fetchUserById(userId).get().getUserId());
//	}

//	@Test
//	void updateUser() {
//		User user = new User(12, "rashi", "rashi124", "rashika", "ka", "user", "user123@gmail.com", 18, 766532241,
//				"dfsyjhb fvghjc");
//		when(repository.save(user)).thenReturn(user);
//		assertEquals(user, service.updateUser(user));
//
//	}

}
