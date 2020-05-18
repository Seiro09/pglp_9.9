package fr.uvsq21504875;

public class Carre implements Forme {
  private String nom;
  private Point HG;
  private int cote;

  public Carre(String nom, int x, int y, int cote){
    this.nom=nom;
    this.HG= new Point("HG",x,y);
    this.cote=cote;
  }

  @Override
  public void move(int x, int y) {
    this.HG.setX(this.HG.getX()+x);
    this.HG.setY(this.HG.getY()+y);
  }

  public String toString(){
    return "Carre(Point=("
        +this.HG.getX()
        +","
        +this.HG.getY()
        +"),"
        +"Point=("
        +(this.HG.getX()+cote)
        +","
        +this.HG.getY()
        +"),"
        +"Point=("
        +this.HG.getX()
        +","
        +(this.HG.getY()+cote)
        +"),"
        +"Point=("
        +(this.HG.getX()+cote)
        +","
        +(this.HG.getY()+cote)
        +"),"
        +"cote="
        +this.cote
        +")";
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

  public Point getHG() {
    return HG;
  }

  public int getCote() {
    return cote;
  }
}
