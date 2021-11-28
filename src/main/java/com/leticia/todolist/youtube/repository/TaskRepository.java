package com.leticia.todolist.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leticia.todolist.youtube.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
