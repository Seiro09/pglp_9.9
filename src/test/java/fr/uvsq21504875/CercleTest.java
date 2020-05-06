package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CercleTest {
  @Test
  public void move() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,10);
    System.out.println(c1.toString());
    c1.move(10,20);
    System.out.println(c1.toString());
  }

  @Test
  public void print() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    c1.print();
  }

}