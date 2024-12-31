package com.agung.uas.service

import com.agung.uas.repository.BookRepository
import com.agung.uas.model.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {
    @Autowired
    BookRepository bookRepository

    List<Book> findAll() {
        bookRepository.findAll()
    }

    Book findById(Integer id) {
        bookRepository.findById(id).orElse(null)
    }

    Book save(Book book) {
        bookRepository.save(book)
    }

    void deleteById(Integer id) {
        bookRepository.deleteById(id)
    }
}
