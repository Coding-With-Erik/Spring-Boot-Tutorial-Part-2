package com.codingwitherik.library.library

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Library", description = "Endpoints for libraries")
@RequestMapping("library")
class LibraryController(
    private val libraryService: LibraryService
) {

    @PostMapping
    @Operation(summary = "Create library", operationId = "createLibrary")
    fun create(@RequestBody param: LibraryParam): LibraryResponse {
        return LibraryResponse(libraryService.create(param.toEntity()))
    }

    @GetMapping("{id}")
    @Operation(summary = "Get library", operationId = "getLibrary")
    fun get(@PathVariable id: Long): LibraryResponse {
        return LibraryResponse(libraryService.findOneOrThrow(id))
    }

    @PutMapping("{id}")
    @Operation(summary = "Update library", operationId = "updateLibrary")
    fun update(@PathVariable id: Long, @RequestBody param: LibraryParam): LibraryResponse {
        return LibraryResponse(libraryService.update(id, param.toEntity()))
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete library", operationId = "deleteLibrary")
    fun delete(@PathVariable id: Long) {
        libraryService.delete(id)
    }
}