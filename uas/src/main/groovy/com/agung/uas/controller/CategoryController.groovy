package com.agung.uas.controller

import com.agung.uas.model.Category
import com.agung.uas.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
class CategoryController {
    @Autowired
    CategoryService categoryService

    @GetMapping
    List<Category> getAllCategories() {
        categoryService.findAll()
    }

    @GetMapping("/{id}")
    Category getCategoryById(@PathVariable('id') Integer id) {
        categoryService.findById(id)
    }

    @PostMapping
    Category createCategory(@ModelAttribute Category category) {
        categoryService.save(category)
    }

    @PutMapping("/{id}")
    Category updateCategory(@PathVariable('id') Integer id, @ModelAttribute Category category) {
        Category existingCategory = categoryService.findById(id)
        if (existingCategory) {
            existingCategory.name = category.name
            return categoryService.save(existingCategory)
        }
        return null
    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable('id') Integer id) {
        categoryService.deleteById(id)
    }
}
