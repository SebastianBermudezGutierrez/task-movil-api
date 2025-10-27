package com.gestionTareas.gestionTareas.controller;

import com.gestionTareas.gestionTareas.entity.Task;
import com.gestionTareas.gestionTareas.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8100", "http://localhost:4200"})
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    /**
     * GET /api/tasks - Obtiene todas las tareas
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    
    /**
     * GET /api/tasks/{id} - Obtiene una tarea por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * GET /api/tasks/category/{categoryId} - Obtiene tareas por categoría
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Task>> getTasksByCategory(@PathVariable Long categoryId) {
        List<Task> tasks = taskService.getTasksByCategory(categoryId);
        return ResponseEntity.ok(tasks);
    }
    
    /**
     * POST /api/tasks - Crea una nueva tarea
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        try {
            Task createdTask = taskService.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * PUT /api/tasks/{id} - Actualiza una tarea existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        try {
            Task updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(updatedTask);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("no encontrada")) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * PATCH /api/tasks/{id}/toggle - Alterna el estado de completado de una tarea
     */
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Task> toggleTaskCompleted(@PathVariable Long id) {
        try {
            Optional<Task> taskOpt = taskService.getTaskById(id);
            if (taskOpt.isPresent()) {
                Task task = taskOpt.get();
                task.setCompleted(!task.getCompleted());
                Task updatedTask = taskService.updateTask(id, task);
                return ResponseEntity.ok(updatedTask);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * DELETE /api/tasks/{id} - Elimina una tarea
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
