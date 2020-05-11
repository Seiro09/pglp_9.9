package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeCercleTest {
  @Test
  public void execute() throws Exception {
    CompositeForme cf = new CompositeForme("cf1");
    CommandeCercle commandeCercle = new CommandeCercle(new String[]{"c4", "50", "50", "64"},cf);
    commandeCercle.execute();
    cf.print();
  }

  @Test
  public void execute2() throws Exception{
    CompositeForme cf = new CompositeForme("cf1");
    CommandeCercle commandeCercle = new CommandeCercle(new String[]{"c4", "50", "64"},cf);
    commandeCercle.execute();
    cf.print();
  }

  @Test
  public void execute3() throws Exception{
    CompositeForme cf = new CompositeForme("cf1");
    CommandeCercle commandeCercle = new CommandeCercle(new String[]{"c4", "50", "50", "a"},cf);
    commandeCercle.execute();
    cf.print();
  }
}