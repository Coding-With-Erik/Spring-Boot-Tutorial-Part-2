package com.codingwitherik.library.librarybook

import com.codingwitherik.library.book.BookResponse
import com.codingwitherik.library.library.LibraryResponse

class LibraryBookParam {
    var bookId: Long? = null
    var id: String? = null
}

class LibraryBookResponse() {
    var id: String? = null
    var book: BookResponse? = null
    var library: LibraryResponse? = null

    constructor(libraryBook: LibraryBook): this() {
        this.id = libraryBook.id
        this.book = libraryBook.book?.let { BookResponse(it) }
        this.library = libraryBook.library?.let { LibraryResponse(it) }
    }
}