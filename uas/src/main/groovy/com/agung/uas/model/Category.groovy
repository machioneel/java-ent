package com.agung.uas.model

import jakarta.persistence.*

@Entity
@Table(name = "categories")
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    @Column(nullable = false)
    String name
}
