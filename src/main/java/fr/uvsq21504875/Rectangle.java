package fr.uvsq21504875;

public class Rectangle implements Forme {
  private String nom;
  private Point HG;
  int longueur;
  int largeur;

  public Rectangle(String nom, int x1, int y1, int longueur, int largeur){
    this.nom=nom;
    this.HG=new Point("HG",x1,y1);
  }

  public Point getHG() {
    return HG;
  }


  @Override
  public void move(int x, int y) {
    this.HG.setX(this.HG.getX()+x);
    this.HG.setY(this.HG.getY()+y);
  }

  public String toString(){
    return "Rectangle(Point=("
        +this.HG.getX()
        +","
        +this.HG.getY()
        +"),"
        +"Point=("
        +(this.HG.getX()+longueur)
        +","
        +this.HG.getY()
        +"),"
        +"Point=("
        +this.HG.getX()
        +","
        +(this.HG.getY()+largeur)
        +"),"
        +"Point=("
        +(this.HG.getX()+longueur)
        +","
        +(this.HG.getY()+largeur)
        +"))";
  }

  @Override
  public void print() {
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }

  @Override
  public String getNom() {
    return nom;
  }

  public int getLongueur() {
    return longueur;
  }

  public int getLargeur() {
    return largeur;
  }

}
