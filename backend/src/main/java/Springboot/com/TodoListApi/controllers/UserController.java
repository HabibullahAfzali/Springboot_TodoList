package Springboot.com.TodoListApi.controllers;

import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.services.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteUser(@PathVariable Long id){

 userService.DeleteUser(id);

		try {
			userService.DeleteUser(id);
			return ResponseEntity.ok("User Successfully Deleted");
		}
		catch (ResponseStatusException ex){

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}

	}
}


