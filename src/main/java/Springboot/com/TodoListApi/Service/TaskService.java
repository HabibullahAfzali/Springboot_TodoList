package Springboot.com.TodoListApi.Service;

import Springboot.com.TodoListApi.Entity.Task;
import Springboot.com.TodoListApi.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

public Task CreateTask(Task task){
	return (Task) taskRepository.save(task);
}

public List<Task> getAllTask(){

	return taskRepository.findAll();
}

}
