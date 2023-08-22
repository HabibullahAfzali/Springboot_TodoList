package Springboot.com.TodoListApi.services;

import Springboot.com.TodoListApi.entities.Task;
import Springboot.com.TodoListApi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
@Autowired
private TaskRepository taskRepository;
public void CreateTask(Task task){
	 taskRepository.save(task);
}

public List<Task> getAllTask(){
	return taskRepository.findAll();
}

}
