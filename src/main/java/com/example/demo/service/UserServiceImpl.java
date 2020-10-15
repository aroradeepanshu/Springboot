package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.request.CreateUserRequest;
import com.example.demo.response.CreateUserResponse;
import com.example.demo.response.GetAllUserResponse;
import com.example.demo.response.GetUserByIdResponse;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	GetAllUserResponse getAllUserResponse; 
	
	@Autowired
	GetUserByIdResponse getUserByIdResponse;
	
	@Autowired
	CreateUserResponse createUserResponse;
	
	@Override
	public GetAllUserResponse getUsers() {
		
		List<User> userList = userDao.findAll();
		if(userList.isEmpty()) {
			getAllUserResponse.setMessage("List is empty");
			getAllUserResponse.setStatus(200);
			getAllUserResponse.setUserList(userDao.findAll());
		}else {
			getAllUserResponse.setStatus(200);
			getAllUserResponse.setMessage("List of Users");
			getAllUserResponse.setUserList(userDao.findAll());
		}
		return getAllUserResponse;
	}



	@Override
	public GetUserByIdResponse getUserById(String id) {
		
		int parsedId;
		
		try {
			parsedId = Integer.parseInt(id);
		}catch(Exception e) {
			getUserByIdResponse.setStatus(400);
			getUserByIdResponse.setMessage("Id should contain only numeric value of integer type");
			getUserByIdResponse.setUser(null);
			return getUserByIdResponse;
		}
		
		Optional<User> user  = userDao.findById(parsedId);
		User userObj;
		if(user.isPresent()) {
		 userObj = user.get();
		}else {
		 userObj=null;
		}
		
		
		if(userObj != null) {
			getUserByIdResponse.setStatus(200);
			getUserByIdResponse.setMessage("User found");
			getUserByIdResponse.setUser(userObj);
		}else {
			getUserByIdResponse.setStatus(404);
			getUserByIdResponse.setMessage("No User found");
			getUserByIdResponse.setUser(null);
		}
		
		return getUserByIdResponse;
	}

	@Override
	public CreateUserResponse createUser(Object reqObj) {
		
		ArrayList<Object> list = CreateUserRequest.requestHandler((Map)reqObj);
		
		User user = (User)list.get(0);
		String msg = (String)list.get(1);
		
		if(user != null ) {
			User userWithEmail = userDao.findByEmail(user.getEmail());
			if(userWithEmail != null) {
				user = null;
				msg = "Email id already exist";
			}
		}
		
		if(user!=null) {
			userDao.save(user);
			createUserResponse.setMessage(msg);
			createUserResponse.setStatus(200);
			createUserResponse.setUser(user);
		}else {
			createUserResponse.setMessage(msg);
			createUserResponse.setStatus(400);
			createUserResponse.setUser(user);
		}
		
		return createUserResponse;
	}

}
