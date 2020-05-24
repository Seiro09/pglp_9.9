package fr.uvsq21504875;

public class Carre implements Forme {
  /**
   * Nom du Carre.
   */
  private String nom;
  /**
   * Point du Carre.
   */
  private Point HG;
  /**
   * Coté du Carré.
   */
  private int cote;

  /**
   * Constructeur du Carre.
   *
   * @param nom Nom du Carré.
   * @param x Abscisse du Carré.
   * @param y Ordonnée du Carré.
   * @param cote Coté du Carré.
   */
  public Carre(final String nom, final int x, final int y, final int cote){
    this.nom = nom;
    this.HG = new Point("HG", x, y);
    this.cote = cote;
  }

  /**
   * Méthode de déplacement d'un carré.
   *
   * @param x Déplacement en abscisse.
   * @param y Déplacement en ordonnées.
   */
  @Override
  public void move(final int x, final int y) {
    this.HG.setX(this.HG.getX()+x);
    this.HG.setY(this.HG.getY()+y);
  }

  /**
   * Méthode d'affichage d'une fonction.
   *
   * @return La chaine générée.
   */
  public String toString(){
    return "Carre(Point=("
         + this.HG.getX()
         + ","
         + this.HG.getY()
         + "),"
         + "Point=("
         + (this.HG.getX()+cote)
         + ","
         + this.HG.getY()
         + "),"
         + "Point=("
         + this.HG.getX()
         + ","
         + (this.HG.getY()+cote)
         + "),"
         + "Point=("
         + (this.HG.getX()+cote)
         + ","
         + (this.HG.getY()+cote)
         + "),"
         + "cote="
         + this.cote
         + ")";
  }

  /**
   * Fonction d'affichage du Carre.
   */
  @Override
  public void print() {
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }
  /**
   * Getter du Nom.
   *
   * @return Le nom du Carre.
   */
  @Override
  public String getNom() {
    return nom;
  }

  /**
   * Getter du Point.
   *
   * @return Le point du Carre.
   */
  public Point getHG() {
    return HG;
  }

  /**
   * Getter du coté.
   *
   * @return Le coté du Carre.
   */
  public int getCote() {
    return cote;
  }
}
