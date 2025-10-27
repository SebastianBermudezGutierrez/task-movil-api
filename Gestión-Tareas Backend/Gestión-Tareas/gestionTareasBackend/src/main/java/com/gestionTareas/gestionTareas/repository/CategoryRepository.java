package com.gestionTareas.gestionTareas.repository;

import com.gestionTareas.gestionTareas.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    /**
     * Busca una categoría por nombre (case insensitive)
     */
    Optional<Category> findByNameIgnoreCase(String name);
    
    /**
     * Verifica si existe una categoría con el nombre dado (case insensitive)
     */
    boolean existsByNameIgnoreCase(String name);
    
    /**
     * Busca categorías ordenadas por nombre
     */
    List<Category> findAllByOrderByNameAsc();
}
