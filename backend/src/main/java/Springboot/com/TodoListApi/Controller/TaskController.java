package Springboot.com.TodoListApi.Controller;

import Springboot.com.TodoListApi.Entity.Task;
import Springboot.com.TodoListApi.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
@PostMapping()
	public Task CreateTask(@RequestBody Task task){
		return taskService.CreateTask(task);
	}

	@GetMapping
	public  List<Task> AllTask(){
		return taskService.getAllTask();
	}
}
