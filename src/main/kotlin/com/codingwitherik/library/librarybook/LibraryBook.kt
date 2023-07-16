package com.codingwitherik.library.librarybook

import com.codingwitherik.library.book.Book
import com.codingwitherik.library.library.Library
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class LibraryBook {
    @Id
    var id: String? = null

    @ManyToOne
    var book: Book? = null

    @ManyToOne
    var library: Library? = null
}