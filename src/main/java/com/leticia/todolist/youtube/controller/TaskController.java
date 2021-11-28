package com.leticia.todolist.youtube.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.leticia.todolist.youtube.model.Task;
import com.leticia.todolist.youtube.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Slf4j
public class TaskController {

	TaskService taskService;
	
	@PostMapping("/tasks")
	public ResponseEntity createTask(@RequestBody Task task) {
		task = taskService.createTask(task);
		log.info("Criando uma nova tarefa com as informações [{}]", task);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
		
	}

	@GetMapping("/tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks() {
		log.info("Listando todas as tarefas cadastradas");
		return taskService.listAll();
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id) {
		log.info("Buscando tarefa por id [{}]", id);
		return taskService.findTaskById(id);
	}

	@PutMapping("tasks/{id}")
	public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
		log.info("Atualizando a tarefa com id [{}] as novas informações são: [{}]", id, task);
		return taskService.updateById(task, id);
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
		log.info("Exluindo tarefa com id [{}]", id);
		return taskService.deleteById(id);
	}

}

