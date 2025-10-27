package com.gestionTareas.gestionTareas.service;

import com.gestionTareas.gestionTareas.entity.Task;
import com.gestionTareas.gestionTareas.repository.CategoryRepository;
import com.gestionTareas.gestionTareas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    /**
     * Obtiene todas las tareas
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    /**
     * Obtiene una tarea por ID
     */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    /**
     * Obtiene tareas por categoría
     */
    public List<Task> getTasksByCategory(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }
    
    /**
     * Crea una nueva tarea
     */
    public Task createTask(Task task) {
        // Verificar que la categoría existe
        if (task.getCategoryId() == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        
        if (!categoryRepository.existsById(task.getCategoryId())) {
            throw new IllegalArgumentException("Categoría no encontrada con ID: " + task.getCategoryId());
        }
        
        return taskRepository.save(task);
    }
    
    /**
     * Actualiza una tarea existente
     */
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada con ID: " + id));
        
        // Verificar que la categoría existe si se está actualizando
        if (taskDetails.getCategoryId() != null) {
            if (!categoryRepository.existsById(taskDetails.getCategoryId())) {
                throw new IllegalArgumentException("Categoría no encontrada con ID: " + taskDetails.getCategoryId());
            }
            task.setCategoryId(taskDetails.getCategoryId());
        }
        
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setCompleted(taskDetails.getCompleted());
        task.setPriority(taskDetails.getPriority());
        
        return taskRepository.save(task);
    }
    
    /**
     * Elimina una tarea por ID
     */
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada con ID: " + id));
        
        taskRepository.delete(task);
    }
}
