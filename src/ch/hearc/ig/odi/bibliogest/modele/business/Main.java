/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 31.05.18 14:51
 */

package ch.hearc.ig.odi.bibliogest.modele.business;

import ch.hearc.ig.odi.bibliogest.controleur.MockPersistance;
import ch.hearc.ig.odi.bibliogest.modele.api.DetectLanguageAPI;
import ch.hearc.ig.odi.bibliogest.modele.api.GoodreadsAPI;
import ch.hearc.ig.odi.bibliogest.modele.api.GoogleTranslateAPI;

public class Main {
  public static void main(String[] args) {
    //MockPersistance.init();

    System.out.println("Bibliothèque :"+MockPersistance.getLibrary());
    System.out.println("Liste d'envies :"+MockPersistance.getWishlist());

    System.out.println("Livres similaires : "+GoodreadsAPI.getSimilarBooks(MockPersistance.getLibrary().getBookcase().get(0).getIsbn10()));

    System.out.println("getBookFromISBN (de MockPersistance) : "+
        MockPersistance.getBookFromISBN(MockPersistance.getLibrary().getBookcase().get(0).getIsbn10()));

    System.out.println(MockPersistance.bookIsInLibrary("207058464X")); //True
    System.out.println(MockPersistance.bookIsInWishlist("207058464X")); //False

    System.out.println(MockPersistance.bookIsInLibrary("2070584925")); //False
    System.out.println(MockPersistance.bookIsInWishlist("2070584925")); //True
  }
}
