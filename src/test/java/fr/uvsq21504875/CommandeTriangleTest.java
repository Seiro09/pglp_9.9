package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeTriangleTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"t1", "0", "0", "10", "0", "0", "10"});
    CommandeTriangle commandeTriangle = new CommandeTriangle(i);
    commandeTriangle.execute();
  }
}