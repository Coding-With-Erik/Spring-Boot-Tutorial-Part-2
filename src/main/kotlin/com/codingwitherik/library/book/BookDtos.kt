package com.codingwitherik.library.book

import com.codingwitherik.library.library.LibraryResponse

class BookResponse() {
    var id: Long? = null
    var name: String? = null
    var author: String? = null
    var isbn: String? = null
    var libraries: Set<LibraryResponse> = emptySet()

    constructor(book: Book) : this() {
        this.id = book.id
        this.name = book.name
        this.author = book.author
        this.isbn = book.isbn
        this.libraries =
            book.libraryBooks.distinctBy { it.library }
                .mapNotNull { libraryBook -> libraryBook.library?.let { LibraryResponse(it) } }.toSet()
    }
}

class BookParam {
    fun toEntity(): Book {
        val entity = Book()
        entity.isbn = this.isbn
        entity.author = this.author
        entity.name = this.name
        return entity
    }

    var name: String? = null
    var author: String? = null
    var isbn: String? = null
}