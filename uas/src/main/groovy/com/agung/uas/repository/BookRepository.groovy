package com.agung.uas.repository

import com.agung.uas.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository extends JpaRepository<Book, Integer> {
}
