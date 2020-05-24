package fr.uvsq21504875;

public class Triangle implements Forme{

  /**
   * Nom du Triangle.
   */
  private String nom;
  /**
   * Point p1.
   */
  private Point p1;
  /**
   * Point p2.
   */
  private Point p2;
  /**
   * Point p3.
   */
  private Point p3;

  /**
   * Constructeur de Triangle.
   *
   * @param nom Nom du Triangle
   * @param x1 Abscisse du p1
   * @param y1 Ordonnée du p1
   * @param x2 Abscisse du p2
   * @param y2 Ordonnée du p2
   * @param x3 Abscisse du p3
   * @param y3 Ordonnée du p3
   */
  public Triangle(final String nom,
                  final int x1, final int y1,
                  final int x2, final int y2,
                  final int x3, final int y3) {
    this.nom = nom;
    this.p1 = new Point("p1", x1, y1);
    this.p2 = new Point("p2", x2, y2);
    this.p3 = new Point("p3", x3, y3);
  }

  /**
   * Getter du point p1.
   *
   * @return Le point p1
   */
  public Point getP1() {
    return p1;
  }

  /**
   * Getter du point p2.
   *
   * @return Le point p2
   */
  public Point getP2() {
    return p2;
  }

  /**
   * Getter du point p3.
   *
   * @return Le point p3
   */
  public Point getP3() {
    return p3;
  }

  /**
   * Méthode de déplacement d'un objet.
   *
   * @param x Le déplacement sur x
   * @param y Le déplacement sur y
   */
  @Override
  public void move(final int x, final int y) {
    this.p1.setX(this.p1.getX()+x);
    this.p1.setY(this.p1.getY()+y);
    this.p2.setX(this.p2.getX()+x);
    this.p2.setY(this.p2.getY()+y);
    this.p3.setX(this.p3.getX()+x);
    this.p3.setY(this.p3.getY()+y);
  }

  /**
   * Méthode d'affichage d'une fonction.
   *
   * @return La chaine générée.
   */
  @Override
  public String toString() {
    return "Triangle(p1=("
        + this.p1.getX()
        + ","
        + this.p1.getY()
        + "),"
        + "p2=("
        + this.p2.getX()
        + ","
        + this.p2.getY()
        + "),"
        + "p3=("
        + this.p3.getX()
        + ","
        + this.p3.getY()
        + "))";
  }

  /**
   * Fonction d'affichage du Triangle.
   */
  @Override
  public void print() {
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }

  /**
   * Getter du Nom.
   *
   * @return Le nom du Triangle.
   */
  @Override
  public String getNom() {
    return this.nom;
  }

  /**
   * Setter du Nom
   *
   * @param nom Le nom souhaité.
   */
  public void setNom(final String nom) {
    this.nom = nom;
  }
}
