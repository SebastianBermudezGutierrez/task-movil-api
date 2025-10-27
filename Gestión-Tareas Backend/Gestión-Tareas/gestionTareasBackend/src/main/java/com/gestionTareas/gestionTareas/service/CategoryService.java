package com.gestionTareas.gestionTareas.service;

import com.gestionTareas.gestionTareas.entity.Category;
import com.gestionTareas.gestionTareas.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    /**
     * Obtiene todas las categorías ordenadas por nombre
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByNameAsc();
    }
    
    /**
     * Obtiene una categoría por ID
     */
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    
    /**
     * Crea una nueva categoría
     */
    public Category createCategory(Category category) {
        // Verificar si ya existe una categoría con el mismo nombre
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Ya existe una categoría con el nombre: " + category.getName());
        }
        
        return categoryRepository.save(category);
    }
    
    /**
     * Actualiza una categoría existente
     */
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
        
        // Verificar si el nuevo nombre ya existe (excluyendo la categoría actual)
        if (!category.getName().equalsIgnoreCase(categoryDetails.getName()) &&
            categoryRepository.existsByNameIgnoreCase(categoryDetails.getName())) {
            throw new IllegalArgumentException("Ya existe una categoría con el nombre: " + categoryDetails.getName());
        }
        
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        
        return categoryRepository.save(category);
    }
    
    /**
     * Elimina una categoría por ID
     */
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con ID: " + id));
        
        categoryRepository.delete(category);
    }
}
