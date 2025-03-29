package com.example.td1 // Déclare le package | Declares the package

// Classe normale pour gérer la logique de bibliothèque | Regular class for library logic
class Library {

    // Liste mutable contenant les livres | Mutable list to store books
    private val books = mutableListOf<Book>()

    // Fonction pour ajouter un livre à la bibliothèque | Adds a book to the library
    fun addBook(book: Book) {
        books.add(book) // Ajoute le livre à la liste | Add book to the list
        println("Livre ajoute : $book") // Affiche confirmation | Print confirmation
    }

    // Supprime un livre par son ID | Remove a book by ID
    fun removeBook(id: Int) {
        val removed = books.removeIf { it.id == id } // Supprime si ID correspond | Remove if ID matches
        if (removed)
            println("Livre avec ID $id supprime.") // Message si supprimé | Message if removed
        else
            println("Aucun livre trouve avec cet ID.") // Sinon, erreur | Else, error message
    }

    // Recherche les livres par titre (insensible à la casse) | Search books by title (case-insensitive)
    fun searchBookByTitle(title: String) {
        val results = books.filter { it.title.contains(title, ignoreCase = true) }
        if (results.isEmpty())
            println("Aucun livre trouve avec ce titre.") // Aucun résultat | No result
        else
            results.forEach { println(it) } // Affiche tous les livres trouvés | Print each result
    }

    // Recherche par auteur (insensible à la casse) | Search books by author (case-insensitive)
    fun searchBookByAuthor(author: String) {
        val results = books.filter { it.author.contains(author, ignoreCase = true) }
        if (results.isEmpty())
            println("Aucun livre trouve pour cet auteur.")
        else
            results.forEach { println(it) }
    }

    // Emprunter un livre par ID | Borrow a book by ID
    fun borrowBook(id: Int) {
        val book = books.find { it.id == id } // Recherche du livre | Find the book
        when {
            book == null -> println("Livre non trouve.") // Pas trouvé | Not found
            !book.available -> println("Ce livre est deja emprunte.") // Déjà emprunté | Already borrowed
            else -> {
                book.available = false // Marque comme emprunté | Mark as borrowed
                println("Vous avez emprunte : ${book.title}")
            }
        }
    }

    // Retourner un livre | Return a book
    fun returnBook(id: Int) {
        val book = books.find { it.id == id }
        when {
            book == null -> println("Livre non trouve.")
            book.available -> println("Ce livre n'etait pas emprunte.")
            else -> {
                book.available = true
                println("Livre retourne : ${book.title}")
            }
        }
    }

    // Affiche tous les livres dans la bibliothèque | Display all books
    fun displayBooks() {
        if (books.isEmpty()) {
            println("Aucun livre dans la bibliotheque.")
        } else {
            println("Liste des livres :")
            books.forEach { println(it) } // Affiche chaque livre | Print each book
        }
    }
}
