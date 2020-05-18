package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
  @Test
  public void move() throws Exception {
    Rectangle r1 = new Rectangle("r1",0,0,10,15);
    System.out.println(r1.toString());
    r1.move(10,20);
    System.out.println(r1.toString());
  }

  @Test
  public void print() throws Exception {
    Rectangle r1 = new Rectangle("r1",0,0,10,15);
    r1.print();
  }

}