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
import ch.hearc.ig.odi.bibliogest.modele.api.GoogleTranslateAPI;

public class Main {
  public static void main(String[] args) {
    MockPersistance.init();

    System.out.println("Bibliothèque :"+MockPersistance.getLibrary());
    System.out.println("Liste d'envies :"+MockPersistance.getWishlist());

    System.out.println(DetectLanguageAPI.detectLanguage("C'est une drôle d'histoire"));
  }
}
