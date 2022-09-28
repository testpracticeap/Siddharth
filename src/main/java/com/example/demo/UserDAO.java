package com.example.demo;

public class UserDAO {
	
	 public static UserList list = new UserList();
	    
	    static {
	          list.getUserList().add(new UserResponse( 1,"sid","sid@sgc.com","56788"));


	            list.getUserList().add(new UserResponse(2,"athulya","sfry@sddf.com","3456"));


	            list.getUserList().add(new UserResponse(3,"debosmita","sefdg@drtt.com","2346799"));


	            list.getUserList().add(new UserResponse(4, "Moyin","qwrsyu@rfcvv.com","4555677"));    
	         }
	    
	    public UserList getAllUserList() {
	        return list;
	    }
	    
	    public void addUser(UserResponse user) {
	        list.getUserList().add(user);
	    }

	}


