package com.hcdev.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Lista de tarefas
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {


    List<TaskModel> findByIdUser(UUID idUser);
}
