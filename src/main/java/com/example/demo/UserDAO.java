package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	 public static List<UserResponse> list=new ArrayList<>();
	    
	    static {
	          list.add(new UserResponse( 1,"siddharth","sid@test.com","9876543210", "24 h.l sarkar road,kolkata","biology"));


	            list.add(new UserResponse(2,"athulya","athulya@test.com","1234567890", "ubantuk road,kerala","maths"));


	            list.add(new UserResponse(3,"debosmita","debosmita@test.com","1234567899","baguihati north,kolkata","computer"));


	            list.add(new UserResponse(4, "Gaurav","gaurav@test.com","1234567889","whitefield,bangalore","physics"));    
	         }
	    
	    public List<UserResponse> getAllUserResponse() {
	        return list;
	    }
	    
	    public void addUser(UserResponse b) {
	        list.add(b);
	    }

	    public void updateUser(UserResponse user, int id) {



	          list= list.stream().map(b->{
	               if(b.getID()==id) {
	                   b.setName(user.getName());
	                   b.setEmail(user.getEmail());
	                   b.setPhoneno(user.getPhoneno());
	                   b.setAddress(user.getAddress());
	                   b.setSubject(user.getSubject());
	               }
	               return b;
	           }).collect(Collectors.toList());
	}
	    
	    public void deleteUser(int Id) {
	        list=list.stream().filter(user->{
	            if(user.getID()!=Id) {
	                return true;
	            }else {
	                return false;
	            }
	        }).collect(Collectors.toList());
	    }
}


