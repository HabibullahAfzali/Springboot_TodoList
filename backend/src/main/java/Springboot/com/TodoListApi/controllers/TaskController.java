package Springboot.com.TodoListApi.controllers;

import Springboot.com.TodoListApi.entities.Task;
import Springboot.com.TodoListApi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {
	@Autowired
	private  TaskService taskService;
@PostMapping()
	public ResponseEntity<String> AddTask(@RequestBody Task task){
		 taskService.CreateTask(task);
		 return ResponseEntity.ok("Task Successfully Created!");
	}
	@GetMapping
	public ResponseEntity< List<Task>> AllTask(){
	List<Task> tasks = taskService.getAllTask();
	return ResponseEntity.ok(tasks);
	}
}
