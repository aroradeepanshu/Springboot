package com.example.demo.request;

import java.util.ArrayList;
import java.util.Map;

import com.example.demo.entity.User;

public class CreateUserRequest {
	
	public static ArrayList<Object> requestHandler(Map reqObj) {
		
		ArrayList<Object> list = new ArrayList<>();
		
		if(reqObj.get("name") == null || reqObj.get("age") == null || reqObj.get("gender") == null || reqObj.get("type") == null || reqObj.get("email") == null) {
			list.add(null);
			list.add("One or more required feild is missing");
			return list;
		}
		
		if(reqObj.get("name").getClass().getName() != "java.lang.String") {
			list.add(null);
			list.add("Name should be of String type");
			return list;
		}
		
		if(reqObj.get("age").getClass().getName() != "java.lang.Integer") {
			list.add(null);
			list.add("Age should be of Integer type");
			return list;
		}
		
		if(reqObj.get("gender").getClass().getName() != "java.lang.String") {
			list.add(null);
			list.add("gender should be of String type");
			return list;
		}
		
		if(reqObj.get("type").getClass().getName() != "java.lang.String") {
			list.add(null);
			list.add("type should be of String type");
			return list;
		}
		
		if(reqObj.get("email").getClass().getName() != "java.lang.String") {
			list.add(null);
			list.add("email should be of String type");
			return list;
		}
		
		String name = (String)reqObj.get("name");
		int age = (int)reqObj.get("age");
		String gender = ((String)reqObj.get("gender")).toLowerCase();
		String type = ((String)reqObj.get("type")).toLowerCase();
		String email = ((String)reqObj.get("email")).toLowerCase();
		
		if(!name.matches("[a-zA-Z]+")){
			list.add(null);
			list.add("Name should contain only letters");
			return list;
		}else if(age<18 || age > 60){
			list.add(null);
			list.add("Age should be between 18 and 60");
			return list;	
		}else if(!(gender.equals("male") || gender.equals("female"))){
			list.add(null);
			list.add("Gender should be either male or female");
			return list;
		}else if(!(type.equals("user") || type.equals("admin"))){
			list.add(null);
			list.add("Type should be either User or Admin");
			return list;
		}else if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			list.add(null);
			list.add("Please enter a valid email address");
			return list;
		}
		else {
			User user =  new User(name,age, gender ,type,email);
			list.add(user);
			list.add("Success");
			return list;
		}
		
	};

}
