package Springboot.com.TodoListApi.services;
import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepository;


	public void saveUser(User user) {
		 userRepository.save(user);

	}
	public List<User> getAllUser(){

		return userRepository.findAll();
	}
	public Optional<User> getUserById(Long userId){
		return userRepository.findById(userId);

	}

	public void deleteUser(Long id){
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isEmpty()){
			System.out.println("User not exist");
		}
		userRepository.deleteById(id);

	}

//	public void createUserWithProfilePicture(
//			String username,
//			String email,
//			String password,
//			MultipartFile profilePicture
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
//
//		userRepository.save(user);
//	}
//
//	public void updateUserProfilePicture(Long userId, MultipartFile profilePicture){
//		User user= userRepository.findById(userId).orElseGet(()->new User());
//		try {
//			user.setProfilePicture(profilePicture.getBytes());
//			userRepository.save(user);
//		} catch (IOException e) {
//			throw new RuntimeException("Failed to update profile picture", e);
//		}
//	}



}
