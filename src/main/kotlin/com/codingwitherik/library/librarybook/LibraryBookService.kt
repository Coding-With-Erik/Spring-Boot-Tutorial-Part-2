package com.codingwitherik.library.librarybook

import com.codingwitherik.library.book.Book
import com.codingwitherik.library.book.BookService
import com.codingwitherik.library.library.Library
import com.codingwitherik.library.library.LibraryService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LibraryBookService(
    private val repository: LibraryBookRepository,
    private val bookService: BookService,
    private val libraryService: LibraryService
) {
    fun addBook(libraryId: Long, bookId: Long?, id: String?): LibraryBook {
        return repository.save(
            LibraryBook().apply {
                this.id = id ?: throw IllegalArgumentException("No ID supplied")
                this.book = bookId?.let { bookService.findOneOrThrow(bookId) } ?: throw IllegalArgumentException("No book ID supplied")
                this.library = libraryService.findOneOrThrow(libraryId)
            }
        )
    }

    @Transactional
    fun removeBook(libraryId: Long, id: String) {
        repository.deleteByLibraryIdAndId(libraryId, id)
    }

    fun search(libraryId: Long, name: String?, author: String?, isbn: String?, pageable: Pageable): Page<LibraryBook> {
        return repository.findAll(
            Example.of(LibraryBook().apply {
                this.book = Book().apply {
                    this.author = author
                    this.isbn = isbn
                    this.name = name
                }
                this.library = Library().apply {
                    this.id = libraryId
                }
            }, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase()), pageable
        )
    }
}