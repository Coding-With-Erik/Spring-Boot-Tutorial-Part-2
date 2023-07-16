package com.codingwitherik.library.library

import jakarta.persistence.*

@Entity
class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var email: String? = null
    var website: String? = null
    var address: String? = null
}