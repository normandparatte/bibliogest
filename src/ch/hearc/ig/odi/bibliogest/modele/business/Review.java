/*
 * Etablissement : HEG-ARC
 * Cours : ODI SP18
 * Projet : Bibliogest
 * Auteurs : Normand Paratte & Francis Hêche
 * Date : 31.05.18 10:55
 */

package ch.hearc.ig.odi.bibliogest.modele.business;

import java.util.Objects;

public class Review {
  // -----------------------------------------------------------------------------------------------
  // ----- PROPRIETES ------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  private String description;
  private Integer rating;

  // -----------------------------------------------------------------------------------------------
  // ----- CONSTRUCTEURS ---------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  /**
   * Constructeur complet d'un avis
   * @param description
   * @param rating
   */
  public Review(String description, Integer rating) {
    this.description = description;
    setRating(rating);
  }

  // -----------------------------------------------------------------------------------------------
  // ----- FONCTIONS METIERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------

  // -----------------------------------------------------------------------------------------------
  // ----- GETTERS & SETTERS -----------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    // La note doit être comprise entre 1 et 5
    if(rating>=0 && rating <=5) {
      this.rating = rating;
    }
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
    Review review = (Review) o;
    return Objects.equals(description, review.description) &&
        Objects.equals(rating, review.rating);
  }

  @Override
  public int hashCode() {

    return Objects.hash(description, rating);
  }

  @Override
  public String toString() {
    return "Review{" +
        "description='" + description + '\'' +
        ", rating=" + rating +
        '}';
  }
}
