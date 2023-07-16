package com.codingwitherik.library.librarybook

import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("library/{libraryId}/book")
class LibraryBookController(
    private val service: LibraryBookService
) {
    @GetMapping
    fun search(
        @PathVariable libraryId: Long,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) author: String?,
        @RequestParam(required = false) isbn: String?,
        @ParameterObject pageable: Pageable
    ): Page<LibraryBookResponse> {
        return service.search(libraryId, name, author, isbn, pageable).map {
            LibraryBookResponse(it)
        }
    }

    @PostMapping
    fun addBook(@PathVariable libraryId: Long, @RequestBody libraryBookParam: LibraryBookParam): LibraryBookResponse {
        return LibraryBookResponse(service.addBook(libraryId, libraryBookParam.bookId, libraryBookParam.id))
    }

    @DeleteMapping("{id}")
    fun deleteBook(@PathVariable libraryId: Long, @PathVariable id: String) {
        service.removeBook(libraryId, id)
    }
}