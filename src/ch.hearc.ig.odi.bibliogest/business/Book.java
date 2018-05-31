/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 30.05.18 20:59
 */

package ch.hearc.ig.odi.bibliogest.business;

import java.util.Date;

public class Book {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private String id;
  private String title;
  private String description;
  private String isbn10;
  private String isbn13;
  private String image_url;
  private Date publication_date;
  private String publisher;
  private Integer ratings_count;
  private Integer ratings_sum;
  private Double average_rating;
  private Author author;
  private Review personal_review;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Constructeur avec les informations de base
   * @param id Numéro identifiant
   * @param title Titre
   * @param description Description
   */
  public Book(String id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
  }

  /**
   * Constructeur complet d'un livre
   * @param id Numéro identifiant
   * @param title Titre
   * @param description Description
   * @param isbn10 ISBN sur 10 caractères
   * @param isbn13 ISBN sur 13 caractères
   * @param image_url URL de l'image de la couverture du livre
   * @param publication_date Date de publication
   * @param publisher Editeur
   * @param ratings_count Nombre d'avis sur le livre
   * @param ratings_sum Somme de toutes les évaluations
   * @param author Auteur
   * @param personal_review Avis personnel du livre
   */
  public Book(String id, String title, String description, String isbn10, String isbn13,
      String image_url, Date publication_date, String publisher, Integer ratings_count,
      Integer ratings_sum, Author author, Review personal_review) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isbn10 = isbn10;
    this.isbn13 = isbn13;
    this.image_url = image_url;
    this.publication_date = publication_date;
    this.publisher = publisher;
    this.ratings_count = ratings_count;
    this.ratings_sum = ratings_sum;
    this.author = author;

    //Calcul de la moyenne
    average_rating = calculateRatingsAverage();
  }

  /**
   * Constructeur d'un livre sans l'avis personnel
   * @param id Numéro identifiant
   * @param title Titre
   * @param description Description
   * @param isbn10 ISBN sur 10 caractères
   * @param isbn13 ISBN sur 13 caractères
   * @param image_url URL de l'image de la couverture du livre
   * @param publication_date Date de publication
   * @param publisher Editeur
   * @param ratings_count Nombre d'avis sur le livre
   * @param ratings_sum Somme de toutes les évaluations
   * @param author Auteur
   */
  public Book(String id, String title, String description, String isbn10, String isbn13,
      String image_url, Date publication_date, String publisher, Integer ratings_count,
      Integer ratings_sum, Author author) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isbn10 = isbn10;
    this.isbn13 = isbn13;
    this.image_url = image_url;
    this.publication_date = publication_date;
    this.publisher = publisher;
    this.ratings_count = ratings_count;
    this.ratings_sum = ratings_sum;
    this.author = author;

    //Calcul de la moyenne
    average_rating = calculateRatingsAverage();
  }
// -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private Double calculateRatingsAverage(){
    return Double.valueOf(ratings_sum) / Double.valueOf(ratings_count);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIsbn10() {
    return isbn10;
  }

  public void setIsbn10(String isbn10) {
    this.isbn10 = isbn10;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public Date getPublication_date() {
    return publication_date;
  }

  public void setPublication_date(Date publication_date) {
    this.publication_date = publication_date;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getRatings_count() {
    return ratings_count;
  }

  public void setRatings_count(Integer ratings_count) {
    this.ratings_count = ratings_count;

    //Recalcul de la moyenne
    average_rating = calculateRatingsAverage();
  }

  public Integer getRatings_sum() {
    return ratings_sum;
  }

  public void setRatings_sum(Integer ratings_sum) {
    this.ratings_sum = ratings_sum;

    //Recalcul de la moyenne
    average_rating = calculateRatingsAverage();
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Double getAverage_rating() {
    return average_rating;
  }

  public void setAverage_rating(Double average_rating) {
    this.average_rating = average_rating;
  }

  public Review getPersonal_review() {
    return personal_review;
  }

  public void setPersonal_review(Review personal_review) {
    this.personal_review = personal_review;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS UTILES ------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  @Override
  public String toString() {
    return "Book{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", isbn10='" + isbn10 + '\'' +
        ", isbn13='" + isbn13 + '\'' +
        ", image_url='" + image_url + '\'' +
        ", publication_date=" + publication_date +
        ", publisher='" + publisher + '\'' +
        ", ratings_count=" + ratings_count +
        ", ratings_sum=" + ratings_sum +
        ", average_rating=" + average_rating +
        ", author=" + author +
        ", personal_review=" + personal_review +
        '}';
  }
}
