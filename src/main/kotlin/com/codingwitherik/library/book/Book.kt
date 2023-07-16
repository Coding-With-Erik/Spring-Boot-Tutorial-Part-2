package com.codingwitherik.library.book

import com.codingwitherik.library.librarybook.LibraryBook
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var author: String? = null
    var isbn: String? = null

    @OneToMany(mappedBy = "book")
    var libraryBooks: Set<LibraryBook> = emptySet()
}