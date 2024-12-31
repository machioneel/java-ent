package com.agung.uas.service

import com.agung.uas.repository.CategoryRepository
import com.agung.uas.model.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {
    @Autowired
    CategoryRepository categoryRepository

    List<Category> findAll() {
        categoryRepository.findAll()
    }

    Category findById(Integer id) {
        categoryRepository.findById(id).orElse(null)
    }

    Category save(Category category) {
        categoryRepository.save(category)
    }

    void deleteById(Integer id) {
        categoryRepository.deleteById(id)
    }
}
