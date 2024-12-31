package com.agung.uas.model

import jakarta.persistence.*

@Entity
@Table(name = "books")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false)
    String name

    @Column(nullable = false)
    String isbn

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category
}

