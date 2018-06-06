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

  /**
   * Permet de detecter le language d'un texte
   * @param sentence Texte sur lequel effectuer la detection de language
   * @return Langue du texte passé en paramètre
   */
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

    client.close();

    return language;
  }

  /**
   * Traduit un texte en francais
   * @param sentence Texte à traduire en français
   * @return Texte en français
   */
  public static String traductInFrench(String sentence) {
    // ---------------------------------------------------------------------------------------------
    // ----- TRADUCTION SI NECESSAIRE --------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    if(sentence.length()>0){
      if (!DetectLanguageAPI.detectLanguage(sentence).toUpperCase().equals("FR")) {
        return GoogleTranslateAPI.
            translate(DetectLanguageAPI.detectLanguage(sentence), "FR", sentence);
      }
      return sentence;
    }
    return "";
  }
}
