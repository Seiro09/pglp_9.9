package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeSaveTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c7", "50", "50", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    i.setParametersT(new String[]{"c11", "25", "25", "32"});
    commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    i.setParametersT(new String[]{"c15", "35", "35", "22"});
    commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    CommandeSave commandeSave = new CommandeSave(i);
    commandeSave.execute();
  }


}