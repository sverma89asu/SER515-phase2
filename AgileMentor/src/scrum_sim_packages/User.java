package com.example.springboot;

// This tells Hibernate to make a table out of this class
public class User {

  private String username;

  private String email;
  
  private String password;
  
  private String create_time;

  public String getName() {
    return username;
  }

  public void setName(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getTime() {
	    return create_time;
	  }

  public void setTime(String create_time) {
	    this.create_time = create_time;
	  }

  public String getPassword() {
		    return password;
		  }
  
  public void setPassword(String password) {
		    this.password = password;
		  }
	  
}
