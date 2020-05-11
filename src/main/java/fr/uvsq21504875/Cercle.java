package fr.uvsq21504875;

public class Cercle implements Forme{
  private String nom;
  private Point centre;
  private double rayon;

  public Cercle(String nom, int x, int y, double rayon){
    this.nom=nom;
    this.centre = new Point("Centre",x,y);
    this.rayon=rayon;
  }

  public void move(int x, int y){
    this.centre.setX(this.centre.getX()+x);
    this.centre.setY(this.centre.getY()+y);
  }

  public String toString(){
    return "Cercle(centre=("
        +this.centre.getX()
        +","
        +this.centre.getY()
        +"),rayon="
        +this.rayon
        +")";
  }

  public void print(){
    AfficheForme a=new AfficheForme();
    a.affiche(this.toString());
  }

  public String getNom() {
    return nom;
  }

  public Point getCentre() {
    return centre;
  }

  public double getRayon() {
    return rayon;
  }
}
