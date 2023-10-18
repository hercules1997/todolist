package com.hcdev.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// Modelo da tabela de tarefas
@Data
@Entity(name = "tb_tasks") // nome para a tabela
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50) // Limitando o tamanho de caracteres na coluna de to título
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String Priority;

    // Tratamento de erro de limite de caracteres
    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
    }

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
