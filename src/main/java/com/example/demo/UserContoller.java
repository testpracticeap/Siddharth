package com.example.demo;
import com.example.demo.UserDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserContoller {

	@Autowired
	
	private UserDAO userdao;  
	    
	     @GetMapping( path = "/UserResponse")
	              
	      public List<UserResponse> getUserResponse() {
			
	    	 return userdao.getAllUserResponse();
		}
	          

	     @PostMapping("/UserResponse")
	    	      	  
	    public UserResponse addUser(@RequestBody UserResponse user)
	    {
	    	userdao.addUser(user);
	    	return user;
	    }
	     
	     @PutMapping("/UserResponse/{Id}")
	     public UserResponse updateuser(@RequestBody UserResponse user, @PathVariable("Id") int Id) {
	         
	         userdao.updateUser(user, Id);
	         return user;
	     }
	     @DeleteMapping("/UserResponse/{Id}")
	     public void deleteUser(@PathVariable("Id") int Id) {
	         userdao.deleteUser(Id);
	     }
	     
	     
}

	     






