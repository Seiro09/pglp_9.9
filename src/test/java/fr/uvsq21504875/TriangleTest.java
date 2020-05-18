package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
  @Test
  public void move() throws Exception {
    Triangle t1 = new Triangle("t1",0,0,10,10, 20,20);
    System.out.println(t1.toString());
    t1.move(10,20);
    System.out.println(t1.toString());
  }

  @Test
  public void print() throws Exception {
    Triangle t1 = new Triangle("t1",0,0,10,10, 20,20);
    t1.print();
  }

}