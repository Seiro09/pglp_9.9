package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeFormeTest {
  @Test
  public void add() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    Cercle c2 = new Cercle("c2",0,10,16);
    CompositeForme cf = new CompositeForme();
    cf.add(c1);
    cf.add(c2);
    System.out.println(cf.children.size());
  }

  @Test
  public void move() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    Cercle c2 = new Cercle("c2",0,10,16);
    CompositeForme cf = new CompositeForme();
    cf.add(c1);
    cf.add(c2);
    Cercle c3= new Cercle("c3",10,10,17);
    CompositeForme cf2= new CompositeForme();
    cf2.add(c3);
    cf2.add(cf);
    cf2.move(15,20);
    cf2.print();
  }

  @Test
  public void print() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    Cercle c2 = new Cercle("c2",0,10,16);
    CompositeForme cf = new CompositeForme();
    cf.add(c1);
    cf.add(c2);
    Cercle c3= new Cercle("c3",10,10,17);
    CompositeForme cf2= new CompositeForme();
    cf2.add(c3);
    cf2.add(cf);
    cf2.print();
  }

}