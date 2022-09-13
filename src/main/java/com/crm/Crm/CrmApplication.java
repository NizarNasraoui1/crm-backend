package com.crm.Crm;

import com.crm.Crm.entity.Role;
import com.crm.Crm.entity.User;
//import com.crm.Crm.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
	public class CrmApplication {
	@Bean
	org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}



//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ADMIN"));;
//			userService.saveUser(new User(null, "admin", "admin", "admin", new ArrayList<>()));
//			userService.addRoleToUser("admin", "ADMIN");
//		};
//	}


}
