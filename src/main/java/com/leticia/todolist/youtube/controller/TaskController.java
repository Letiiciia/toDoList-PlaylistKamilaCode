package com.leticia.todolist.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.leticia.todolist.youtube.model.Task;
import com.leticia.todolist.youtube.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/tasks")
	public ResponseEntity createTask(@RequestBody Task task) {
		task = taskService.createTask(task);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
		
	}

	@GetMapping("/tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks() {
		return taskService.listAll();
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id) {
		return taskService.findTaskById(id);
	}

}

