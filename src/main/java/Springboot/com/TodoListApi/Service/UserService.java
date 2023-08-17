package Springboot.com.TodoListApi.Service;

import Springboot.com.TodoListApi.Entity.User;
import Springboot.com.TodoListApi.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User SaveUser(User user) {
		return userRepository.save(user);

	}

	public List<User> getAllUser(){

		return userRepository.findAll();
	}
}
