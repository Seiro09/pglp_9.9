package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeRedoTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "50", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    i.setParametersT(new String[]{"c1", "25", "25", "32"});
    commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
    CommandeUndo commandeUndo = new CommandeUndo(i);
    commandeUndo.execute();
    commandePrint = new CommandePrint(i);
    commandePrint.execute();
    CommandeRedo commandeRedo = new CommandeRedo(i);
    commandeRedo.execute();
    commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }

}