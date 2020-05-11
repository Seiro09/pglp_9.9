package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeCercleTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "50", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }

  @Test
  public void execute2() throws Exception{
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }

  @Test
  public void execute3() throws Exception{
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "64", "a"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }
}