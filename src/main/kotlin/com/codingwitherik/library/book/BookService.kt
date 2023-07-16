package com.codingwitherik.library.book

import org.springframework.stereotype.Service

@Service
class BookService(
    private val repository: BookRepository
) {
    fun create(book: Book): Book {
        return repository.save(book)
    }

    fun findOneOrThrow(id: Long): Book {
        return repository.findById(id).orElseThrow { NoSuchElementException("No Book with id $id found") }
    }

    fun update(id: Long, book: Book): Book {
        val toUpdate = findOneOrThrow(id)
        toUpdate.author = book.author
        toUpdate.name = book.name
        toUpdate.isbn = book.isbn
        return repository.save(toUpdate)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}