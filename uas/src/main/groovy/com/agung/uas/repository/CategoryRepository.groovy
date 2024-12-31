package com.agung.uas.repository

import com.agung.uas.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository extends JpaRepository<Category, Integer> {
}
