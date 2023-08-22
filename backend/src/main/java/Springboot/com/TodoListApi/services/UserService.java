package Springboot.com.TodoListApi.services;

import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private  UserRepository userRepository;

	public void SaveUser(User user) {
		 userRepository.save(user);

	}

	public List<User> getAllUser(){

		return userRepository.findAll();
	}

	public void DeleteUser(Long id){
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isEmpty()){
			System.out.println("User not exist");
		}
		userRepository.deleteById(id);

	}

}
