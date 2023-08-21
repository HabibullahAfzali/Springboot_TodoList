package Springboot.com.TodoListApi.Controller;

import Springboot.com.TodoListApi.Entity.User;
import Springboot.com.TodoListApi.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User CreateUser(@RequestBody User user){

		return userService.SaveUser(user);
	}
	@GetMapping
	public List<User> getUsers(){
		return userService.getAllUser();
	}
}


