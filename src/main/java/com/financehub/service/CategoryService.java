package com.financehub.service;

import com.financehub.model.Category;
import com.financehub.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Criar categoria
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Listar todas
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Buscar por ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    // Atualizar categoria
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existing = getCategoryById(id); // já valida se existe

        existing.setName(updatedCategory.getName());
        existing.setMonthlyLimit(updatedCategory.getMonthlyLimit());

        return categoryRepository.save(existing);
    }

    // Deletar categoria
    public void deleteCategory(Long id) {
        Category category = getCategoryById(id); // valida se existe
        categoryRepository.delete(category);
    }
}