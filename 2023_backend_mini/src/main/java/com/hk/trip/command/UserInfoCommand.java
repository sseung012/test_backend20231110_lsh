package com.hk.trip.command;


//import org.hibernate.validator.constraints.Length;
//
//import jakarta.validation.constraints.NotBlank;

public class UserInfoCommand {

	private String id;

	private String name;

	private String password;

	private String email;

	private String address;
	
	private String role;

	public UserInfoCommand() {
	      super();
	}
	
	public UserInfoCommand(String id,String name, String password,String email,
							String address,String role) {
	      super();
	      this.id = id;
	      this.name = name;
	      this.password = password;
	      this.email = email;
	      this.address = address;
	      this.role=role;
	   }

	   public String getId() {
	      return id;
	   }

	   public void setId(String id) {
	      this.id = id;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	   public String getAddress() {
	      return address;
	   }

	   public void setAddress(String address) {
	      this.address = address;
	   }
	   
	   public String getRole() {
		   return role;
	   }
	   
	   public void setRole(String role) {
		   this.role= role;
	   }

	   @Override
	   public String toString() {
	      return "AddUserCommand [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
	            + ", address=" + address + ", role=" + role+ "]";
	   }
	   
	
	
}
