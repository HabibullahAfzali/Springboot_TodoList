package Springboot.com.TodoListApi.controllers;
import java.io.IOException;
import java.util.logging.Logger;
import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
@Autowired
	private  UserService userService;

//	@PostMapping
//	public ResponseEntity<String> createUserWithProfilePicture(
//			@RequestParam String username,
//			@RequestParam String email,
//			@RequestParam String password,
//			@RequestParam(required = false) MultipartFile profilePicture
//	) {
//		User user = new User();
//		user.setUsername(username);
//		user.setEmail(email);
//		user.setPassword(password);
//
//		if (profilePicture != null && !profilePicture.isEmpty()) {
//			try {
//				user.setProfilePicture(profilePicture.getBytes());
//			} catch (IOException e) {
//				throw new RuntimeException("Failed to update profile picture", e);
//			}
//		}
//		userService.createUserWithProfilePicture(username, email, password, profilePicture);
//		return ResponseEntity.ok("User registered with profile picture!");
//	}

	@PostMapping
	public ResponseEntity<String> CreateUser(@RequestBody User user){

		 userService.saveUser(user);
		 return ResponseEntity.ok("Successfully added!");
	}
//	@PostMapping("/upload-profile-picture/{id}")
//	public ResponseEntity<String> uploadProfilePicture(@PathVariable Long id, @RequestParam MultipartFile file) {
//
//		userService.updateUserProfilePicture(id, file);
//		return ResponseEntity.ok("Profile picture uploaded successfully!");
//	}

	@GetMapping
	public ResponseEntity< List<User>> getUsers(){
	List<User> users=	userService.getAllUser();
	return ResponseEntity.ok(users);
	}
	@DeleteMapping("/{id}")
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


