package com.example.demo.service;


import java.util.Map;

import com.example.demo.entity.User;
import com.example.demo.response.CreateUserResponse;
import com.example.demo.response.GetAllUserResponse;
import com.example.demo.response.GetUserByIdResponse;

public interface UserService {
	
	public GetAllUserResponse getUsers();
	
	public GetUserByIdResponse getUserById(String id);
	
	public CreateUserResponse createUser(Object reqObj);

}
