package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarreTest {
  @Test
  public void move() throws Exception {
    Carre c1 = new Carre("c1",0,0,10);
    System.out.println(c1.toString());
    c1.move(10,20);
    System.out.println(c1.toString());
  }

  @Test
  public void print() throws Exception {
    Carre c1 = new Carre("c1",0,0,10);
    c1.print();
  }

}