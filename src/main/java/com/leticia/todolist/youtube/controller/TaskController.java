package com.leticia.todolist.youtube.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	@ApiOperation(value = "Criando uma nova tarefa")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
			@ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informações")
	})
	@PostMapping("/tasks")
	public ResponseEntity createTask(@RequestBody Task task) {
		task = taskService.createTask(task);
		log.info("Criando uma nova tarefa com as informações [{}]", task);
		return ResponseEntity.status(HttpStatus.CREATED).body(task);
		
	}

	@ApiOperation(value = "Listando todas as tarefaa")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
			@ApiResponse(code = 500, message = "Houve um erro ao listar as tarefas")
	})
	@GetMapping("/tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks() {
		log.info("Listando todas as tarefas cadastradas");
		return taskService.listAll();
	}

	@ApiOperation(value = "Buscando uma tarefa pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Tarefa encontrada com sucesso"),
			@ApiResponse(code = 404, message = "Não foi encontrada nenhuma tarefa com esse id")
	})
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id) {
		log.info("Buscando tarefa por id [{}]", id);
		return taskService.findTaskById(id);
	}

	@ApiOperation(value = "Atualizando uma tarefa ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
			@ApiResponse(code = 404, message = "Não foi possível atualizar a tarefa - tarefa não encontrada")
	})
	@PutMapping("tasks/{id}")
	public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
		log.info("Atualizando a tarefa com id [{}] as novas informações são: [{}]", id, task);
		return taskService.updateById(task, id);
	}

	@ApiOperation(value = "Excluindo uma tarefa")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Excluida com sucesso"),
			@ApiResponse(code = 404, message = "Não foi possível atualizar a tarefa - tarefa não encontrada")
	})
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
		log.info("Exluindo tarefa com id [{}]", id);
		return taskService.deleteById(id);
	}

}

