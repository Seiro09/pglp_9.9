package fr.uvsq21504875;

public class Point {
  private String nom;
  private int x;
  private int y;

  public Point(String nom, int x, int y){
    this.nom=nom;
    this.x = x;
    this.y = y;
  }

  public int getY() {
    return y;
  }

  public int getX() {
    return x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setX(int x) {
    this.x = x;
  }

  @Override
  public String toString() {
    return this.nom+"(x="+x+",y="+y+")";
  }
}
