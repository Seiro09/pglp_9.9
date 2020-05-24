package fr.uvsq21504875;

public class Cercle implements Forme {
  /**
   * Nom du Cercle
   */
  private String nom;
  /**
   * Centre du Cercle.
   */
  private Point centre;
  /**
   * Rayon du Cercle.
   */
  private double rayon;

  /**
   * Constructeur du Cercle.
   *
   * @param nom Nom du Cercle.
   * @param x Abscisse du Cercle.
   * @param y Ordonnée du Cercle.
   * @param rayon Rayon du Cercle.
   */
  public Cercle(final String nom, final int x,
                final int y, final double rayon) {
    this.nom = nom;
    this.centre = new Point("Centre", x, y);
    this.rayon = rayon;
  }

  /**
   * Méthode de déplacement d'un Cercle.
   *
   * @param x Déplacement en abscisse.
   * @param y Déplacement en ordonnées.
   */
  public void move(final int x, final int y) {
    this.centre.setX(this.centre.getX() + x);
    this.centre.setY(this.centre.getY() + y);
  }

  /**
   * Méthode d'affichage d'une fonction.
   *
   * @return La chaine générée.
   */
  public String toString() {
    return "Cercle(centre=("
        + this.centre.getX()
        + ","
        + this.centre.getY()
        + "),rayon="
        + this.rayon
        + ")";
  }

  /**
   * Fonction d'affichage du Triangle.
   */
  public void print() {
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }

  /**
   * Getter du Nom.
   *
   * @return Le nom du Triangle.
   */
  public String getNom() {
    return nom;
  }

  /**
   * Getter du Centre.
   *
   * @return Le centre du Triangle.
   */
  public Point getCentre() {
    return centre;
  }

  /**
   * Getter du rayon.
   *
   * @return Le rayon du Triangle.
   */
  public double getRayon() {
    return rayon;
  }
}
