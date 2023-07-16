package com.codingwitherik.library.book

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    private val service: BookService
) {
    @PostMapping
    fun create(@RequestBody bookParam: BookParam): BookResponse {
        return BookResponse(service.create(bookParam.toEntity()))
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): BookResponse {
        return BookResponse(service.findOneOrThrow(id))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody bookParam: BookParam): BookResponse {
        return BookResponse(service.update(id, bookParam.toEntity()))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}