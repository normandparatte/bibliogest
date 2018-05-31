package ch.hearc.ig.odi.bibliogest.modele.api;

import ch.hearc.ig.odi.bibliogest.modele.business.Author;
import ch.hearc.ig.odi.bibliogest.modele.business.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import org.json.XML;

public class GoodreadsAPI {

  private static final String APIKEY = "5e46FPUdlqxlRMLu9I7sw";

  public GoodreadsAPI() {
  }

  public Book getBookFromISBN(String isbn) {

    Client client = ClientBuilder.newClient();

    // ISBN pour harry potter --> 2070518426
    WebTarget myResource = client.target("https://www.goodreads.com/book/isbn/" + isbn)
        .queryParam("key", APIKEY)
        // Le format xml est choisi car le format JSON n'est pas propre
        .queryParam("format", "xml");

    // Le XML recu est transformer en JSON
    JSONObject xmlJSONObj = XML
        .toJSONObject(myResource.request(MediaType.TEXT_PLAIN).get(String.class));
    xmlJSONObj = xmlJSONObj.getJSONObject("GoodreadsResponse");

    // Initialisation de toutes les variables selon objet recu
    String id = String.valueOf(xmlJSONObj.getJSONObject("book").getInt("id"));
    String title = xmlJSONObj.getJSONObject("book").getString("title");
    String description = xmlJSONObj.getJSONObject("book").getString("description");
    String isbn10 = xmlJSONObj.getJSONObject("book").getString("isbn");
    String isbn13 = xmlJSONObj.getJSONObject("book").getString("isbn13");
    String imageUrl = xmlJSONObj.getJSONObject("book").getString("image_url");

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String jour="";
    String mois="";
    String annee="";
    try{
      jour=String.valueOf(xmlJSONObj.getJSONObject("book").getJSONObject("work")
          .getJSONObject("original_publication_day").getInt("content"));
    }catch(Exception e){
      jour="01";
    }
    try{
      mois=String.valueOf(xmlJSONObj.getJSONObject("book").getJSONObject("work")
          .getJSONObject("original_publication_month").getInt("content"));
    }catch(Exception e){
      mois="01";
    }
    try{
      annee=String.valueOf(xmlJSONObj.getJSONObject("book").getJSONObject("work")
          .getJSONObject("original_publication_year").getInt("content"));
    }catch(Exception e){
      annee="2000";
    }
    String date = jour + "/" + mois + "/" + annee;
    Date publication = null;
    try {
      publication = simpleDateFormat.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    String publisher = xmlJSONObj.getJSONObject("book").getString("publisher");
    Integer ratingsCount = xmlJSONObj.getJSONObject("book").getJSONObject("work")
        .getJSONObject("ratings_count").getInt("content");
    Integer ratingsSum = xmlJSONObj.getJSONObject("book").getJSONObject("work")
        .getJSONObject("ratings_sum").getInt("content");

    JSONObject auteurJSON;
    try {
      // S'il y a plusieurs auteurs c'est un tableau
      auteurJSON = (JSONObject) xmlJSONObj.getJSONObject("book").getJSONObject("authors")
          .getJSONArray("author").get(0);
    } catch(Exception e){
      // Sinon c'est un objet
      auteurJSON = (JSONObject) xmlJSONObj.getJSONObject("book").getJSONObject("authors")
          .getJSONObject("author");
    }
    String auteurID = String.valueOf(auteurJSON.getInt("id"));
    String auteurName = auteurJSON.getString("name");
    String auteurImage = auteurJSON.getJSONObject("image_url").getString("content");
    Integer auteurRatingsCount = auteurJSON.getInt("ratings_count");
    Double auteurAverageRating = auteurJSON.getDouble("average_rating");

    // Création de l'auteur
    Author author = new Author(auteurID, auteurName, auteurImage, auteurRatingsCount,
        auteurAverageRating);

    // Création du livre
    Book book = new Book(id, title, description, isbn10, isbn13, imageUrl, publication, publisher,
        ratingsCount, ratingsSum, author);

    //Retourne le titre
    return book;
  }
}
