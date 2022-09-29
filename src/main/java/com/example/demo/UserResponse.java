package com.example.demo;

public class UserResponse {
	
	  private int id;
	    private String name;
	    private String email;
	    private String phoneno;
	    private String address;
	    private String subject;
	    
	    public UserResponse() {
	        
	    }
	    public UserResponse(int id,String name,String email,String phoneno,String address,String subject) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phoneno = phoneno;
	        this.address= address;
	        this.subject=subject;
	    }
	    
	      public int getID() {
	            return id;
	        }

	      public void setID(int id) {
	            this.id = id;
	        }

	      public String getName() {
	            return name;
	        }

	      public void setName(String name) {
	            this.name = name;
	        }
	       
	       public String getEmail() {
	           return email;
	       }
	       
	       public void setEmail(String email) {
	           this.email = email;
	       }
	       
	       public String getPhoneno() {
	          return phoneno;
	       }
	       
	       public void setPhoneno(String phoneno) {
	           this.phoneno = phoneno;
	       }
	       
	       public String getAddress() {
		          return address;
		       }
		       
		       public void setAddress(String address) {
		           this.address = address;
		           
		       }
		       
		       public String getSubject() {
			          return subject;
			       }
			       
			       public void setSubject(String subject) {
			           this.subject=subject;
			       }
	}


