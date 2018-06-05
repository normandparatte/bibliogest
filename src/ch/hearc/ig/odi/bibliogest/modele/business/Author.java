/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 30.05.18 21:09
 */

package ch.hearc.ig.odi.bibliogest.modele.business;

import java.util.Objects;

public class Author {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private String id;
  private String name;
  private String imageUrl;
  private Integer ratingsCount;
  private Double averageRating;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Constructeur complet d'un auteur
   * @param id
   * @param name
   * @param imageUrl
   * @param ratingsCount
   * @param averageRating
   */
  public Author(String id, String name, String imageUrl, Integer ratingsCount,
      Double averageRating) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.ratingsCount = ratingsCount;
    this.averageRating = averageRating;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImage_url() {
    return imageUrl;
  }

  public void setImage_url(String image_url) {
    this.imageUrl = image_url;
  }

  public Integer getRatings_count() {
    return ratingsCount;
  }

  public void setRatings_count(Integer ratings_count) {
    this.ratingsCount = ratings_count;
  }

  public Double getAverage_rating() {
    return averageRating;
  }

  public void setAverage_rating(Double average_rating) {
    this.averageRating = average_rating;
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
    Author author = (Author) o;
    return Objects.equals(id, author.id) &&
        Objects.equals(name, author.name) &&
        Objects.equals(imageUrl, author.imageUrl) &&
        Objects.equals(ratingsCount, author.ratingsCount) &&
        Objects.equals(averageRating, author.averageRating);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, imageUrl, ratingsCount, averageRating);
  }

  @Override
  public String toString() {
    return "Author{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", ratingsCount=" + ratingsCount +
        ", averageRating=" + averageRating +
        '}';
  }
}
