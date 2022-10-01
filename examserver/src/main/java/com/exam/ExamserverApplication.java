package com.exam;

import com.exam.Model.Role;
import com.exam.Model.User;
import com.exam.Model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication. run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("starting code");

		User user = new User();

	// Setting user details
		user.setFirstName("Samarth");
		user.setLastName("Chouhan");
		user.setUserName("Samarth.Chouhan");
		user.setEmail("samarthraj15@gmail.com");
  		user.setPhone("7772857700");
		user.setPassword("123456");
		user.setProfile("default.png");

		// Setting user role
		Role role = new Role();
		role.setRoleId(44L);
		role.setRoleName("Admin");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		System.out.println("user information: \nusername: "+user.getUserName());
		System.out.println("Role information: \nRolename: "+userRoleSet);
		this.userService.createUser(user,userRoleSet);
		System.out.println("user information: \nusername: "+user.getUserName());
	 }
}
