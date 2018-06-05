package ch.hearc.ig.odi.bibliogest.modele.api;

import ch.hearc.ig.odi.bibliogest.modele.business.Author;
import ch.hearc.ig.odi.bibliogest.modele.business.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import org.json.XML;

public class GoodreadsAPI {

  private static final String APIKEY = "5e46FPUdlqxlRMLu9I7sw";

  /**
   * Récupère un livre selon son ISBN
   * @param isbn ISBN du livre à rechercher
   * @return Livre recherché
   */
  public static Book getBookFromISBN(String isbn) {
    // Envoi de la requête à l'API
    Client client = ClientBuilder.newClient();
    WebTarget myResource = client.target("https://www.goodreads.com/book/isbn/" + isbn)
        .queryParam("key", APIKEY)
        // Le format xml est choisi car le format JSON n'est pas propre
        .queryParam("format", "xml");

    // Le XML recu est transformer en JSON
    JSONObject xmlJSONObj = XML
        .toJSONObject(myResource.request(MediaType.TEXT_PLAIN).get(String.class));
    xmlJSONObj = xmlJSONObj.getJSONObject("GoodreadsResponse").getJSONObject("book");

    client.close();

    //Retourne le livre
    return extractBookInformations(xmlJSONObj);
  }

  /**
   * Récupère des livres similaires au livre passé en paramètre (Via son ISBN)
   * @param isbn ISBN du livre dont les livres similaires doivent être trouvés
   * @return Liste des livres similaires
   */
  public static List<Book> getSimilarBooks(String isbn) {
    // Envoi de la requête à l'API
    Client client = ClientBuilder.newClient();
    WebTarget myResource = client.target("https://www.goodreads.com/book/isbn/" + isbn)
        .queryParam("key", APIKEY)
        // Le format xml est choisi car le format JSON n'est pas propre
        .queryParam("format", "xml");

    // Le XML recu est transformer en JSON
    JSONObject xmlJSONObj = XML
        .toJSONObject(myResource.request(MediaType.TEXT_PLAIN).get(String.class));
    xmlJSONObj = xmlJSONObj.getJSONObject("GoodreadsResponse").getJSONObject("book")
        .getJSONObject("similar_books");

    client.close();

    // Parcours le tableau JSON des livres similaires et les ajoute à la liste
    List<Book> books = new ArrayList<>();

    //On limite le nombre de livre similaire à 5
    Integer numberSimilarbooks=xmlJSONObj.getJSONArray("book").length();
    if(numberSimilarbooks>5){
      numberSimilarbooks=5;
    }

    for (int i = 0; i < numberSimilarbooks; ++i) {
      // Récupère l'ISBN en string mais parfois l'API le retourne sous un int
      String isbnSimilarBook;
      try {
        isbnSimilarBook = xmlJSONObj.getJSONArray("book").getJSONObject(i).getString("isbn");
      } catch (Exception e) {
        isbnSimilarBook = String
            .valueOf(xmlJSONObj.getJSONArray("book").getJSONObject(i).getInt("isbn"));
      }
      try {
        // Récupère le livre selon l'ISBN sinon on a pas toutes les informations necessaires
        books.add(getBookFromISBN(isbnSimilarBook));
      }catch (Exception e){
      }
    }

    client.close();

    //Retourne la liste de livres
    return books;
  }

  /**
   * Extrait les informations d'un JSON et les injecte dans un livre
   * @param BookJSON Livre au format JSON
   * @return Livre créé selon les informations du JSON
   */
  private static Book extractBookInformations(JSONObject BookJSON) {
    // ---------------------------------------------------------------------------------------------
    // ----- RECUPERATION DES INFORMATIONS ---------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    String id = String.valueOf(BookJSON.getInt("id"));
    String title = BookJSON.getString("title");
    String description = BookJSON.getString("description");
    description = DetectLanguageAPI.traductInFrench(description);
    String isbn10 = BookJSON.getString("isbn");
    String isbn13 = BookJSON.getString("isbn13");
    String imageUrl = BookJSON.getString("image_url");
    String publisher = BookJSON.getString("publisher");
    Integer ratingsCount = BookJSON.getJSONObject("work")
        .getJSONObject("ratings_count").getInt("content");
    Integer ratingsSum = BookJSON.getJSONObject("work")
        .getJSONObject("ratings_sum").getInt("content");

    // ----- Gestion de la date --------------------------------------------------------------------
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String jour = "";
    String mois = "";
    String annee = "";
    try {
      jour = String.valueOf(BookJSON.getJSONObject("work")
          .getJSONObject("original_publication_day").getInt("content"));
    } catch (Exception e) {
      jour = "01";
    }
    try {
      mois = String.valueOf(BookJSON.getJSONObject("work")
          .getJSONObject("original_publication_month").getInt("content"));
    } catch (Exception e) {
      mois = "01";
    }
    try {
      annee = String.valueOf(BookJSON.getJSONObject("work")
          .getJSONObject("original_publication_year").getInt("content"));
    } catch (Exception e) {
      annee = "2000";
    }
    String date = jour + "/" + mois + "/" + annee;
    Date publication = null;
    try {
      publication = simpleDateFormat.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // ---------------------------------------------------------------------------------------------
    // ----- CREATION ET RENVOI DES DONNEES --------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // Création de l'auteur
    Author author = extractAuthorInformations(BookJSON);

    // Création du livre
    Book book = new Book(id, title, description, isbn10, isbn13, imageUrl, publication, publisher,
        ratingsCount, ratingsSum, author);

    return book;
  }

  /**
   * Extrait les informations d'un JSON et les injecte dans un auteur
   * @param AuthorJSON Auteur au format JSON
   * @return Auteur créé selon les informations du JSON
   */
  private static Author extractAuthorInformations(JSONObject AuthorJSON) {
    // ---------------------------------------------------------------------------------------------
    // ----- RECUPERATION DES INFORMATIONS ---------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    JSONObject auteurJSON;
    try {
      // S'il y a plusieurs auteurs c'est un tableau
      auteurJSON = (JSONObject) AuthorJSON.getJSONObject("authors")
          .getJSONArray("author").get(0);
    } catch (Exception e) {
      // Sinon c'est un objet
      auteurJSON = (JSONObject) AuthorJSON.getJSONObject("authors")
          .getJSONObject("author");
    }
    String auteurID = String.valueOf(auteurJSON.getInt("id"));
    String auteurName = auteurJSON.getString("name");
    String auteurImage = auteurJSON.getJSONObject("image_url").getString("content");
    Integer auteurRatingsCount = auteurJSON.getInt("ratings_count");
    Double auteurAverageRating = auteurJSON.getDouble("average_rating");

    // ---------------------------------------------------------------------------------------------
    // ----- CREATION ET RENVOI DES DONNEES --------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // Création de l'auteur
    Author author = new Author(auteurID, auteurName, auteurImage, auteurRatingsCount,
        auteurAverageRating);

    return author;
  }
}
