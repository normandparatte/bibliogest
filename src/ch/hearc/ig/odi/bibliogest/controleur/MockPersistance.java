/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 31.05.18 11:58
 */

package ch.hearc.ig.odi.bibliogest.controleur;

import ch.hearc.ig.odi.bibliogest.modele.api.GoodreadsAPI;
import ch.hearc.ig.odi.bibliogest.modele.business.Author;
import ch.hearc.ig.odi.bibliogest.modele.business.Book;
import ch.hearc.ig.odi.bibliogest.modele.business.Bookcase;
import ch.hearc.ig.odi.bibliogest.modele.business.Review;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockPersistance {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private static List<Book> books;
  private static List<Author> authors;
  private static Bookcase library;
  private static Bookcase wishlist;

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Initialisation des listes ainsi que leurs données
   */
  public static void init() {
    books = new ArrayList<>();
    authors = new ArrayList<>();
    library = new Bookcase();
    wishlist = new Bookcase();
    generateMockData();
  }

  /**
   * Insertion des données dans les listes
   */
  private static void generateMockData() {
    Book b1 = GoodreadsAPI.getBookFromISBN("2070584623"); // Harry potter #1
    Book b2 = GoodreadsAPI.getBookFromISBN("207058464X"); // Harry potter #2
    Book b3 = GoodreadsAPI.getBookFromISBN("2070584925"); // Harry potter #3
    Book b4 = GoodreadsAPI.getBookFromISBN("2747014401"); // Eragon #1

    addBookToLibrary(b1);
    addBookToLibrary(b2);
    addBookToWhishlist(b3);
    addBookToLibrary(b4);

    b1.addReview("Super livre !",5);
    b2.addReview("Moins aimé que le premier ...",3);
    b4.addReview("J'adore l'univers et le style de l'écriture",4);
  }

  /**
   * Ajoute un livre à la librairie
   * @param book Livre à ajouter
   */
  public static void addBookToLibrary(Book book){
    library.addBook(book);
    addBook(book);
  }

  /**
   * Ajoute un livre à la liste de souhait
   * @param book Livre à ajouter
   */
  public static void addBookToWhishlist(Book book){
    wishlist.addBook(book);
    addBook(book);
  }

  /**
   * Ajoute un livre dans la liste des livres et un author dans la liste des auteurs
   * @param book Livre à ajouter
   */
  private static void addBook(Book book){
    books.add(book);
    authors.add(book.getAuthor());
  }

  /**
   * Determine si un livre est dans la bibliothèque
   * @param isbn ISBN du livre à chercher dans la bibliothèque
   * @return True si le livre est présent
   */
  public static Boolean bookIsInLibrary(String isbn){
    for(int i=0;i<library.getBookcase().size();++i){
      if(library.getBookcase().get(i).getIsbn10().equals(isbn)){
        return true;
      }else if (library.getBookcase().get(i).getIsbn13().equals(isbn)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determine si un livre est dans la liste de souhait
   * @param isbn ISBN du livre à chercher dans la liste de souhait
   * @return True si le livre est présent
   */
  public static Boolean bookIsInWishlist(String isbn){
    for(int i=0;i<wishlist.getBookcase().size();++i){
      if(wishlist.getBookcase().get(i).getIsbn10().equals(isbn)){
        return true;
      }else if (wishlist.getBookcase().get(i).getIsbn13().equals(isbn)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Retire un livre de la bibliothèque
   * @param isbn ISBN du livre à retirer
   */
  public removeBookFromLibrary(String isbn){
    for(int i=0;i<library.getBookcase().size();++i){
      if(library.getBookcase().get(i).getIsbn10().equals(isbn)){
        library.getBookcase().remove(i);
        break;
      }else if (library.getBookcase().get(i).getIsbn13().equals(isbn)) {
        library.getBookcase().remove(i);
        break;
      }
    }
  }

  /**
   * Retire un livre de la liste de souhait
   * @param isbn ISBN du livre à retirer
   */
  public removeBookFromWishlist(String isbn){
    for(int i=0;i<wishlist.getBookcase().size();++i){
      if(wishlist.getBookcase().get(i).getIsbn10().equals(isbn)){
        wishlist.getBookcase().remove(i);
        break;
      }else if (wishlist.getBookcase().get(i).getIsbn13().equals(isbn)) {
        wishlist.getBookcase().remove(i);
        break;
      }
    }
  }
  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public static Bookcase getLibrary() {
    return library;
  }

  public static Bookcase getWishlist() {
    return wishlist;
  }

  public static void setLibrary(Bookcase library) {
    MockPersistance.library = library;
  }

  public static Book getBookFromISBN(String isbn){
    for(int i=0;i<books.size();++i){
      if(books.get(i).getIsbn10().equals(isbn)){
        return books.get(i);
      }else if (books.get(i).getIsbn13().equals(isbn)) {
        return books.get(i);
      }
    }
    return null;
  }
}
