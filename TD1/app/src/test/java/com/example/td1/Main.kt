package com.example.td1 // Package

// Fonction principale exécutée au démarrage | Main function launched at start
fun main() {
    val library = Library() // Création de la bibliothèque | Create library instance

    // Livres ajoutés par défaut | Preloaded books
    library.addBook(Book(1, "Twilight", "Stephenie Meyer"))
    library.addBook(Book(2, "Alice in Wonderland", "Lewis Carroll"))
    library.addBook(Book(3, "Harry Potter and the Philosopher's Stone", "J.K. Rowling"))
    library.addBook(Book(4, "Harry Potter and the Chamber of Secrets", "J.K. Rowling"))
    library.addBook(Book(5, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling"))
    library.addBook(Book(6, "Harry Potter and the Goblet of Fire", "J.K. Rowling"))
    library.addBook(Book(7, "Harry Potter and the Order of the Phoenix", "J.K. Rowling"))
    library.addBook(Book(8, "Harry Potter and the Half-Blood Prince", "J.K. Rowling"))
    library.addBook(Book(9, "Harry Potter and the Deathly Hallows", "J.K. Rowling"))
    library.addBook(Book(10, "Murder on the Orient Express", "Agatha Christie"))
    library.addBook(Book(11, "Death on the Nile", "Agatha Christie"))
    library.addBook(Book(12, "The Mysterious Affair at Styles", "Agatha Christie"))
    library.addBook(Book(13, "Evil under the Sun", "Agatha Christie"))

    // Menu interactif infini | Infinite menu loop
    while (true) {
        println(
            """
            === Menu de la Bibliotheque ===
            1. Ajouter un livre
            2. Supprimer un livre
            3. Rechercher par titre
            4. Rechercher par auteur
            5. Emprunter un livre
            6. Retourner un livre
            7. Afficher tous les livres
            8. Quitter
        """.trimIndent()
        )

        print("Choix : ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                // Ajout d'un livre | Add a book
                print("Titre : ")
                val title = readLine() ?: ""
                print("Auteur : ")
                val author = readLine() ?: ""
                print("ID : ")
                val id = readLine()?.toIntOrNull() ?: -1
                if (id >= 0) library.addBook(Book(id, title, author))
                else println("ID invalide.")
            }
            2 -> {
                // Suppression | Remove
                print("ID du livre a supprimer : ")
                val id = readLine()?.toIntOrNull() ?: -1
                library.removeBook(id)
            }
            3 -> {
                // Recherche par titre | Search by title
                print("Titre a rechercher : ")
                val title = readLine() ?: ""
                library.searchBookByTitle(title)
            }
            4 -> {
                // Recherche par auteur | Search by author
                print("Auteur a rechercher : ")
                val author = readLine() ?: ""
                library.searchBookByAuthor(author)
            }
            5 -> {
                // Emprunt | Borrow
                print("ID du livre a emprunter : ")
                val id = readLine()?.toIntOrNull() ?: -1
                library.borrowBook(id)
            }
            6 -> {
                // Retour | Return
                print("ID du livre a retourner : ")
                val id = readLine()?.toIntOrNull() ?: -1
                library.returnBook(id)
            }
            7 -> library.displayBooks() // Affichage | Display
            8 -> {
                println("Au revoir !") // Quitte la boucle | Exit loop
                break
            }
            else -> println("Choix invalide.") // Option incorrecte | Invalid choice
        }

        println() // Ligne vide pour la lisibilité | New line for readability
    }
}
