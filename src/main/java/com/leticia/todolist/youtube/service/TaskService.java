package com.leticia.todolist.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leticia.todolist.youtube.model.Task;
import com.leticia.todolist.youtube.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> listAll() {
		return taskRepository.findAll();
	}

	public ResponseEntity<Task> findTaskById(Long id) {
		return taskRepository.findById(id)
				.map(task -> ResponseEntity.ok().body(task))
				.orElse(ResponseEntity.notFound().build());
	}


	
}
