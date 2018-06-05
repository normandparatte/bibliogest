/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 30.05.18 20:59
 */

package ch.hearc.ig.odi.bibliogest.modele.business;

import java.util.Date;
import java.util.Objects;

public class Book {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private String id;
  private String title;
  private String description;
  private String isbn10;
  private String isbn13;
  private String imageUrl;
  private Date publicationDate;
  private String publisher;
  private Integer ratingsCount;
  private Integer ratingsSum;
  private Double averageRating;
  private Author author;
  private Review personalReview;

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
   * @param imageUrl URL de l'image de la couverture du livre
   * @param publicationDate Date de publication
   * @param publisher Editeur
   * @param ratingsCount Nombre d'avis sur le livre
   * @param ratingsSum Somme de toutes les évaluations
   * @param author Auteur
   * @param personalReview Avis personnel du livre
   */
  public Book(String id, String title, String description, String isbn10, String isbn13,
      String imageUrl, Date publicationDate, String publisher, Integer ratingsCount,
      Integer ratingsSum, Author author, Review personalReview) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isbn10 = isbn10;
    this.isbn13 = isbn13;
    this.imageUrl = imageUrl;
    this.publicationDate = publicationDate;
    this.publisher = publisher;
    this.ratingsCount = ratingsCount;
    this.ratingsSum = ratingsSum;
    this.author = author;

    //Calcul de la moyenne
    averageRating = calculateRatingsAverage();
  }

  /**
   * Constructeur d'un livre sans l'avis personnel
   * @param id Numéro identifiant
   * @param title Titre
   * @param description Description
   * @param isbn10 ISBN sur 10 caractères
   * @param isbn13 ISBN sur 13 caractères
   * @param imageUrl URL de l'image de la couverture du livre
   * @param publicationDate Date de publication
   * @param publisher Editeur
   * @param ratingsCount Nombre d'avis sur le livre
   * @param ratingsSum Somme de toutes les évaluations
   * @param author Auteur
   */
  public Book(String id, String title, String description, String isbn10, String isbn13,
      String imageUrl, Date publicationDate, String publisher, Integer ratingsCount,
      Integer ratingsSum, Author author) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isbn10 = isbn10;
    this.isbn13 = isbn13;
    this.imageUrl = imageUrl;
    this.publicationDate = publicationDate;
    this.publisher = publisher;
    this.ratingsCount = ratingsCount;
    this.ratingsSum = ratingsSum;
    this.author = author;

    //Calcul de la moyenne
    averageRating = calculateRatingsAverage();
  }
// -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Calcul la moyenne des notes selon le nombre et la somme des ratings
   *
   * @return Moyenne des notes
   */
  private Double calculateRatingsAverage(){
    return Double.valueOf(ratingsSum) / Double.valueOf(ratingsCount);
  }

  /**
   * Créer et ajoute une review au livre
   *
   * @return Moyenne des notes
   */
  public Review addReview(String description, Integer rating){
    personalReview=new Review(description,rating);
    return personalReview;
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getRatingsCount() {
    return ratingsCount;
  }

  public void setRatingsCount(Integer ratingsCount) {
    this.ratingsCount = ratingsCount;

    //Recalcul de la moyenne
    averageRating = calculateRatingsAverage();
  }

  public Integer getRatingsSum() {
    return ratingsSum;
  }

  public void setRatingsSum(Integer ratingsSum) {
    this.ratingsSum = ratingsSum;

    //Recalcul de la moyenne
    averageRating = calculateRatingsAverage();
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Double getAverageRating() {
    return averageRating;
  }

  public Review getPersonalReview() {
    return personalReview;
  }

  public void setPersonalReview(Review personalReview) {
    this.personalReview = personalReview;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS UTILES ------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(id, book.id) &&
        Objects.equals(title, book.title) &&
        Objects.equals(description, book.description) &&
        Objects.equals(isbn10, book.isbn10) &&
        Objects.equals(isbn13, book.isbn13) &&
        Objects.equals(imageUrl, book.imageUrl) &&
        Objects.equals(publicationDate, book.publicationDate) &&
        Objects.equals(publisher, book.publisher) &&
        Objects.equals(ratingsCount, book.ratingsCount) &&
        Objects.equals(ratingsSum, book.ratingsSum) &&
        Objects.equals(averageRating, book.averageRating) &&
        Objects.equals(author, book.author) &&
        Objects.equals(personalReview, book.personalReview);
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(id, title, description, isbn10, isbn13, imageUrl, publicationDate, publisher,
            ratingsCount, ratingsSum, averageRating, author, personalReview);
  }

  @Override
  public String toString() {
    return "Book{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", isbn10='" + isbn10 + '\'' +
        ", isbn13='" + isbn13 + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", publicationDate=" + publicationDate +
        ", publisher='" + publisher + '\'' +
        ", ratingsCount=" + ratingsCount +
        ", ratingsSum=" + ratingsSum +
        ", averageRating=" + averageRating +
        ", author=" + author +
        ", personalReview=" + personalReview +
        '}';
  }
}
