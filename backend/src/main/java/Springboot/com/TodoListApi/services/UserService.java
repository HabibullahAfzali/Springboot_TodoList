package Springboot.com.TodoListApi.services;

import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
