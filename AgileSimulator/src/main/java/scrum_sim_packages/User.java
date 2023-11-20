package scrum_sim_packages;

import org.json.simple.JSONObject;

import java.util.HashMap;

public class User {

  private String username;

  private String email;
  
  private String password;
  
  private String role;

  public User(String username, String email, String password, String role) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.role = role;
  }

  public JSONObject toJSON() {
      JSONObject jsonObject = new JSONObject();
      HashMap<String, Object> userMap = new HashMap<>();
      userMap.put("username", username);
      userMap.put("email", email);
      userMap.put("password", password);
      userMap.put("role", role);
      jsonObject.putAll(userMap);
      return jsonObject;
  }

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
