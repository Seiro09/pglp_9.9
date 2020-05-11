package fr.uvsq21504875;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeForme implements Forme{
  public String nom;
  protected List<Forme> children = new ArrayList<>();

  public CompositeForme(String nom){
    this.nom=nom;
  }

  public void add(Forme f){
    children.add(f);
  }

  public void remove(Forme f){ children.remove(f); }

  public Iterator<Forme> getChildrens(){
    return children.iterator();
  }


  public void move(int x, int y){
    for (Forme f : children){
      f.move(x,y);
    }
  }

  public void print(){
    for (Forme f : children){
      f.print();
    }
  }

  @Override
  public String getNom() {
    return nom;
  }
}
