package fr.uvsq21504875;

public class Point {
  /**
   * Nom du Point.
   */
  private String nom;
  /**
   * Coordonnées x du point.
   */
  private int x;
  /**
   * Coordonnées y du Point.
   */
  private int y;

  /**
   * Constructeur du point.
   *
   * @param nom Nom du Point.
   * @param x Coordonnées x du point.
   * @param y Coordonnées y du point.
   */
  public Point(final String nom, final int x, final int y) {
    this.nom = nom;
    this.x = x;
    this.y = y;
  }

  /**
   * Getter de la coordonnée x.
   *
   * @return La coordonnée x du Point.
   */
  public int getY() {
    return y;
  }

  /**
   * Getter de la coordonnée y.
   *
   * @return La coordonnée y du Point.
   */
  public int getX() {
    return x;
  }

  /**
   * Setter de la coordonnée y.
   *
   * @param y La valeur à mettre.
   */
  public void setY(final int y) {
    this.y = y;
  }

  /**
   * Setter de la coordonnée x.
   *
   * @param x La valeur à mettre.
   */
  public void setX(final int x) {
    this.x = x;
  }

  /**
   * Méthode d'affichage d'une fonction.
   *
   * @return La chaine générée.
   */
  @Override
  public String toString() {
    return this.nom
        + "(x="
        + x
        + ",y="
        + y
        + ")";
  }
}
