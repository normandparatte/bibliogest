/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 31.05.18 11:26
 */

package ch.hearc.ig.odi.bibliogest.modele.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bookcase {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private ArrayList<Book> bookcase;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Constructeur vide
   */
  public Bookcase() {
    this.bookcase = new ArrayList<>();
  }

  /**
   * Constructeur complet d'une bibliothèque
   *
   * @param bookcase Liste des livres de la bibliothèque
   */
  public Bookcase(List<Book> bookcase) {
    this.bookcase = new ArrayList<>();

    // Parcours tous les livres
    for (int i = 0; i < bookcase.size(); ++i) {
      // Ajoute le livre
      addBook(bookcase.get(i));
    }
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Ajoute un livre à la bibliothèque
   *
   * @param book Livre à ajouter
   */
  public void addBook(Book book) {
    // Flag permettant de dire s'il faut ajouter le livre
    Boolean addBoook = true;

    // Parcours tous les livres
    for (int i = 0; i < bookcase.size(); ++i) {
      // Si le livre existe déjà
      if (book == bookcase.get(i)) {
        //On ne l'ajoutera pas une deuxième fois
        addBoook = false;
        break;
      }
    }
    // S'il faut ajouter le livre
    if (addBoook) {
      this.bookcase.add(book);
    }
  }

  /**
   * Retire un livre de la bibliothèque
   *
   * @param book Livre à retirer
   */
  public void removeBook(Book book) {
    // Parcours tous les livres
    for (int i = 0; i < bookcase.size(); ++i) {
      // Si le livre est bien celui passé en paramètre
      if (book == bookcase.get(i)) {
        // On le supprime
        bookcase.remove(i);
      }
    }
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public List<Book> getBookcase() {
    return bookcase;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS UTILES ------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bookcase bookcase1 = (Bookcase) o;
    return Objects.equals(bookcase, bookcase1.bookcase);
  }

  @Override
  public int hashCode() {

    return Objects.hash(bookcase);
  }

  @Override
  public String toString() {
    return "Bookcase{" +
        "bookcase=" + bookcase +
        '}';
  }
}
