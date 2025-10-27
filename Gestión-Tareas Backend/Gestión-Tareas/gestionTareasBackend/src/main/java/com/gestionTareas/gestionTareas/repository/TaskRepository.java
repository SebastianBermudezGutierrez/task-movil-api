package com.gestionTareas.gestionTareas.repository;

import com.gestionTareas.gestionTareas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    /**
     * Busca tareas por categoría
     */
    List<Task> findByCategoryId(Long categoryId);
    
    /**
     * Busca tareas por estado de completado
     */
    List<Task> findByCompleted(Boolean completed);
    
    /**
     * Busca tareas por prioridad
     */
    List<Task> findByPriority(Task.Priority priority);
    
    /**
     * Busca tareas por categoría y estado de completado
     */
    List<Task> findByCategoryIdAndCompleted(Long categoryId, Boolean completed);
    
    /**
     * Cuenta tareas por categoría y estado
     */
    long countByCategoryIdAndCompleted(Long categoryId, Boolean completed);
    
    /**
     * Cuenta tareas completadas
     */
    long countByCompleted(Boolean completed);
}
