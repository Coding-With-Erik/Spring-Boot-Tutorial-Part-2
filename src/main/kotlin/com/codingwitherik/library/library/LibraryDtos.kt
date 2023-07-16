package com.codingwitherik.library.library

class LibraryParam {
    var name: String? = null
    var email: String? = null
    var website: String? = null
    var address: String? = null

    fun toEntity(): Library {
        val entity = Library()
        entity.name = this.name
        entity.email = this.email
        entity.website = this.website
        entity.address = this.address
        return entity
    }
}

class LibraryResponse() {
    var id: Long? = null
    var name: String? = null
    var email: String? = null
    var website: String? = null
    var address: String? = null

    constructor(library: Library): this() {
        this.id = library.id
        this.name = library.name
        this.email = library.email
        this.website = library.website
        this.address = library.address
    }
}