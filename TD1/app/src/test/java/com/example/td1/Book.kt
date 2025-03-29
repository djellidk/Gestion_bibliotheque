package com.example.td1 // Déclare le package | Declares the package

// Déclaration d'une data class pour représenter un livre | Declares a data class to represent a book
data class Book(
    val id: Int,               // Identifiant unique du livre | Unique ID of the book
    val title: String,         // Titre du livre | Book's title
    val author: String,        // Auteur du livre | Book's author
    var available: Boolean = true // Disponibilité (true = disponible) | Availability (true = available)
)
