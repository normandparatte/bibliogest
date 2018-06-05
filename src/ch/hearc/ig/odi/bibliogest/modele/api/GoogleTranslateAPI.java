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
import org.json.JSONArray;

public class GoogleTranslateAPI {

  /**
   * Traduit un texte
   * @param sentence Texte à traduire
   * @param sourceLanguage Language source
   * @param targetLanguage Language cible
   * @return Texte traduit
   */
  public static String translate(String sourceLanguage, String targetLanguage, String sentence) {
    // Envoi de la requête à l'API
    Client client = ClientBuilder.newClient();
    WebTarget myResource = client.target("https://translate.googleapis.com/translate_a/single")
        .queryParam("client", "gtx")
        .queryParam("sl", sourceLanguage)
        .queryParam("tl", targetLanguage)
        .queryParam("dt", "t")
        .queryParam("q", sentence);

    // On reprend le retour dans un tableau JSON
    JSONArray reponseJSONArray = new JSONArray(myResource.request(MediaType.TEXT_PLAIN).get(String.class));
    reponseJSONArray = reponseJSONArray.getJSONArray(0);

    // Parcours le tableau et reprends les phrases traduites dans retour
    String retour="";
    for(int i=0;i<reponseJSONArray.length();++i){
      retour+=reponseJSONArray.getJSONArray(i).getString(0);
    }

    // Retourne la phrase traduite
    return retour;
  }
}
