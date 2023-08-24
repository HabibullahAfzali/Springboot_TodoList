package Springboot.com.TodoListApi.services;

import Springboot.com.TodoListApi.entities.Task;
import Springboot.com.TodoListApi.entities.User;
import Springboot.com.TodoListApi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
@Autowired
private TaskRepository taskRepository;
public void createTask(Task task){
	 taskRepository.save(task);
}

public List<Task> getAllTask(){
	return taskRepository.findAll();
}
	public Optional<Task> getTaskById(Long taskId){
		return taskRepository.findById(taskId);

	}

	public void deleteTask(Long id){
		Optional<Task> task = taskRepository.findById(id);
		if(task.isEmpty()){
			System.out.println("Task not exist");
		}
		taskRepository.deleteById(id);

	}
}
