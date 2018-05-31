/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 30.05.18 21:09
 */

package ch.hearc.ig.odi.bibliogest.business;

public class Author {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private String id;
  private String name;
  private String image_url;
  private String ratings_count;
  private String average_rating;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Constructeur complet d'un auteur
   * @param id
   * @param name
   * @param image_url
   * @param ratings_count
   * @param average_rating
   */
  public Author(String id, String name, String image_url, String ratings_count,
      String average_rating) {
    this.id = id;
    this.name = name;
    this.image_url = image_url;
    this.ratings_count = ratings_count;
    this.average_rating = average_rating;
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
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public String getRatings_count() {
    return ratings_count;
  }

  public void setRatings_count(String ratings_count) {
    this.ratings_count = ratings_count;
  }

  public String getAverage_rating() {
    return average_rating;
  }

  public void setAverage_rating(String average_rating) {
    this.average_rating = average_rating;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS UTILES ------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  @Override
  public String toString() {
    return "Author{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", image_url='" + image_url + '\'' +
        ", ratings_count='" + ratings_count + '\'' +
        ", average_rating='" + average_rating + '\'' +
        '}';
  }
}
