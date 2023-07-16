package com.codingwitherik.library.library

import org.springframework.stereotype.Service

@Service
class LibraryService(
    private val libraryRepository: LibraryRepository
) {
    fun create(library: Library): Library {
        return libraryRepository.save(library)
    }

    fun findOneOrThrow(id: Long): Library {
        return libraryRepository.findById(id).orElseThrow { NoSuchElementException("No Library found with id $id") }
    }

    fun update(id: Long, library: Library): Library {
        val libraryToUpdate = findOneOrThrow(id)

        libraryToUpdate.website = library.website
        libraryToUpdate.address = library.address
        libraryToUpdate.email = library.email
        libraryToUpdate.name = library.name

        return libraryRepository.save(libraryToUpdate)
    }

    fun delete(id: Long) {
        libraryRepository.deleteById(id)
    }
}