/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 01.06.18 10:21
 */

package ch.hearc.ig.odi.bibliogest.modele.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GoogleTranslateAPI {
  public static String translate(String sourceLanguage, String targetLanguage, String sentence) {

    Client client = ClientBuilder.newClient();

    WebTarget myResource = client.target("https://translate.googleapis.com/translate_a/single")
        .queryParam("client", "gtx")
        .queryParam("sl", sourceLanguage)
        .queryParam("tl", targetLanguage)
        .queryParam("dt", "t")
        .queryParam("q", sentence);

    // On reprend un simple texte que l'on parsera en JSON
    String retour = myResource.request(MediaType.TEXT_PLAIN).get(String.class);

    // Retourne le premier texte entre guillemets
    return retour.split("\"")[1];
  }
}
