package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeCarreTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "50", "64"});
    CommandeCarre commandeCarre = new CommandeCarre(i);
    commandeCarre.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }

}