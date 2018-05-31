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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockPersistance {
  private static List<Book> books;
  private static List<Author> authors;
  private static Bookcase library;
  private static Bookcase wishlist;
  private static GoodreadsAPI goodreadsAPI;

  public static void init() {
    books = new ArrayList<>();
    authors = new ArrayList<>();
    library = new Bookcase();
    wishlist = new Bookcase();
    goodreadsAPI = new GoodreadsAPI();
    generateMockData();
  }

  private static void generateMockData() {
    Book b1 = goodreadsAPI.getBookFromISBN("2070584623"); // Harry potter #1
    Book b2 = goodreadsAPI.getBookFromISBN("207058464X"); // Harry potter #2
    Book b3 = goodreadsAPI.getBookFromISBN("2070584925"); // Harry potter #3
    Book b4 = goodreadsAPI.getBookFromISBN("2747014401"); // Eragon #1

    addBookToLibrary(b1);
    addBookToLibrary(b2);
    addBookToWhishlist(b3);
    addBookToLibrary(b4);
  }

  public static void addBookToLibrary(Book book){
    library.addBook(book);
    addBook(book);
  }

  public static void addBookToWhishlist(Book book){
    wishlist.addBook(book);
    addBook(book);
  }

  private static void addBook(Book book){
    books.add(book);
    authors.add(book.getAuthor());
  }

  public static Bookcase getLibrary() {
    return library;
  }

  public static Bookcase getWishlist() {
    return wishlist;
  }

  public static void setLibrary(Bookcase library) {
    MockPersistance.library = library;
  }
}
