/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 01.06.18 11:26
 */

package ch.hearc.ig.odi.bibliogest.modele.api;

import com.detectlanguage.errors.APIError;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.detectlanguage.DetectLanguage;

public class DetectLanguageAPI {

  private static final String APIKEY = "c177046930ee6a0249548a21067a714a";

  public static String detectLanguage(String sentence) {

    Client client = ClientBuilder.newClient();

    DetectLanguage.apiKey = APIKEY;

    String language;
    try {
      language = DetectLanguage.simpleDetect(sentence);
    } catch (APIError apiError) {
      apiError.printStackTrace();
      language="INCONNU";
    }

    return language;
  }
}
