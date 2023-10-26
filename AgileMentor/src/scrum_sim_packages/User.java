package scrum_sim_packages;

// This tells Hibernate to make a table out of this class
public class User {

  private String username;

  private String email;
  
  private String password;
  
  private String role;

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
	    return role;
	  }

  public void setTime(String role) {
	    this.role = role;
	  }

  public String getPassword() {
		    return password;
		  }
  
  public void setPassword(String password) {
		    this.password = password;
		  }
	  
}
