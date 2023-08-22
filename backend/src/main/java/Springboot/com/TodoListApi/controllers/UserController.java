package Springboot.com.TodoListApi.controllers;

import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<String> CreateUser(@RequestBody User user){

		 userService.SaveUser(user);
		 return ResponseEntity.ok("Successfully added!");
	}
	@GetMapping
	public ResponseEntity< List<User>> getUsers(){
	List<User> users=	userService.getAllUser();
	return ResponseEntity.ok(users);
	}
}


