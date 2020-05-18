package fr.uvsq21504875;

public class Triangle implements Forme{

  private String nom;
  private Point p1;
  private Point p2;
  private Point p3;

  public Triangle(String nom, int x1, int y1, int x2, int y2, int x3, int y3){
    this.nom=nom;
    this.p1 = new Point("p1", x1, y1);
    this.p2 = new Point("p2", x2, y2);
    this.p3 = new Point("p3", x3, y3);
  }

  public Point getP1() {
    return p1;
  }

  public Point getP2() {
    return p2;
  }

  public Point getP3() {
    return p3;
  }

  @Override
  public void move(int x, int y) {
    this.p1.setX(this.p1.getX()+x);
    this.p1.setY(this.p1.getY()+y);
    this.p2.setX(this.p2.getX()+x);
    this.p2.setY(this.p2.getY()+y);
    this.p3.setX(this.p3.getX()+x);
    this.p3.setY(this.p3.getY()+y);
  }

  @Override
  public String toString() {
    return "Triangle(p1=("
        +this.p1.getX()
        +","
        +this.p1.getY()
        +"),"
        +"p2=("
        +this.p2.getX()
        +","
        +this.p2.getY()
        +"),"
        +"p3=("
        +this.p3.getX()
        +","
        +this.p3.getY()
        +"))" ;
  }

  @Override
  public void print() {
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }

  @Override
  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
