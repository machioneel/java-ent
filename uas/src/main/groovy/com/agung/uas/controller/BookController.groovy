package com.agung.uas.controller

import com.agung.uas.model.Book
import com.agung.uas.model.Category
import com.agung.uas.service.BookService
import com.agung.uas.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController {
    @Autowired
    BookService bookService

    @Autowired
    CategoryService categoryService

    @GetMapping
    List<Book> getAllBooks() {
        bookService.findAll()
    }

    @GetMapping("/{id}")
    Book getBookById(@PathVariable('id') Integer id) {
        bookService.findById(id)
    }

    @PostMapping
    Book createBook(@ModelAttribute BookForm bookForm) {
        if (bookForm.getCategoryId() == null) {
            throw new IllegalArgumentException("Category ID must not be null");
        }

        Category category = categoryService.findById(bookForm.getCategoryId() as Integer)
        if (category == null) {
            throw new IllegalArgumentException("Category not found");
        }

        Book book = new Book();
        book.setName(bookForm.getName());
        book.setIsbn(bookForm.getIsbn());
        book.setCategory(category as Category);

        return bookService.save(book);
    }

    @PutMapping("/{id}")
    Book updateBook(@PathVariable('id') Integer id, @ModelAttribute BookForm bookForm) {
        Book existingBook = bookService.findById(id)
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found with ID: " + id)
        }

        if (bookForm.getName() != null) {
            existingBook.setName(bookForm.getName())
        }
        if (bookForm.getIsbn() != null) {
            existingBook.setIsbn(bookForm.getIsbn())
        }
        if (bookForm.getCategoryId() != null) {
            Category category = categoryService.findById(bookForm.getCategoryId() as Integer)
            if (category == null) {
                throw new IllegalArgumentException("Category not found")
            }
            existingBook.setCategory(category)
        }

        return bookService.save(existingBook)
    }

    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable('id') Integer id) {
        bookService.deleteById(id)
    }
}

class BookForm {
    String name
    String isbn
    Long categoryId
}

