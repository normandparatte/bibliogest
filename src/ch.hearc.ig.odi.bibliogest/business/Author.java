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
  private String imageUrl;
  private String ratingsCount;
  private String averageRating;

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
  public Author(String id, String name, String imageUrl, String ratingsCount,
      String averageRating) {
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

  public String getRatings_count() {
    return ratingsCount;
  }

  public void setRatings_count(String ratings_count) {
    this.ratingsCount = ratings_count;
  }

  public String getAverage_rating() {
    return averageRating;
  }

  public void setAverage_rating(String average_rating) {
    this.averageRating = average_rating;
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS UTILES ------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  @Override
  public String toString() {
    return "Author{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", image_url='" + imageUrl + '\'' +
        ", ratings_count='" + ratingsCount + '\'' +
        ", average_rating='" + averageRating + '\'' +
        '}';
  }
}
