package com.codingwitherik.library.librarybook

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying

interface LibraryBookRepository : JpaRepository<LibraryBook, String> {
    @Modifying
    fun deleteByLibraryIdAndId(libraryId: Long, id: String)
}