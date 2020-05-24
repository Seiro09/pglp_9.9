package fr.uvsq21504875;

public class Rectangle implements Forme {
  /**
   * Nom du Rectangle.
   */
  private String nom;
  /**
   * Point du rectangle.
   */
  private Point HG;
  /**
   * Longueur du rectangle.
   */
  private int longueur;
  /**
   * Largeur du Rectangle.
   */
  private int largeur;

  /**
   * Constructeur du Rectangle.
   *
   * @param nom Nom du Rectangle.
   * @param x1 Abscisse du Rectangle.
   * @param y1 Ordonnée du Rectangle.
   * @param longueur Longueur du Rectangle.
   * @param largeur Largeur du Rectangle.
   */
  public Rectangle(final String nom, final int x1, final int y1,
                   final int longueur, final int largeur) {
    this.nom = nom;
    this.HG = new Point("HG", x1, y1);
    this.largeur = largeur;
    this.longueur = longueur;
  }

  /**
   * Getter du Point du Rectangle.
   *
   * @return Le point du rectangle
   */
  public Point getHG() {
    return HG;
  }

  /**
   * Méthode de déplacement d'un objet.
   *
   * @param x Le déplacement sur x
   * @param y Le déplacement sur y
   */
  @Override
  public void move(final int x, final int y) {
    this.HG.setX(this.HG.getX() + x);
    this.HG.setY(this.HG.getY() + y);
  }

  /**
   * Méthode d'affichage d'une fonction.
   *
   * @return La chaine générée.
   */
  public String toString(){
    return "Rectangle(Point=("
         + this.HG.getX()
         + ","
         + this.HG.getY()
         + "),"
         + "Point=("
         + (this.HG.getX()+longueur)
         + ","
         + this.HG.getY()
         + "),"
         + "Point=("
         + this.HG.getX()
         + ","
         + (this.HG.getY()+largeur)
         + "),"
         + "Point=("
         + (this.HG.getX()+longueur)
         + ","
         + (this.HG.getY()+largeur)
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
    return nom;
  }
  /**
   * Getter de la Longueur.
   *
   * @return La longueur du rectangle.
   */
  public int getLongueur() {
    return longueur;
  }
  /**
   * Getter de la largeur.
   *
   * @return La largeur du rectangle.
   */
  public int getLargeur() {
    return largeur;
  }

}
