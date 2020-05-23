package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeGroupeTest {
  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "650", "650", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    i.setParametersT(new String[]{"C4", "50", "50", "64"});
    CommandeCarre commandeCarre= new CommandeCarre(i);
    commandeCarre.execute();
    i.setParametersT(new String[]{"cf1", "c4", "C4"});
    CommandeGroupe commandeGroupe = new CommandeGroupe(i);
    commandeGroupe.execute();
    i.setParametersT(new String[]{"C5", "60", "60", "64"});
    commandeCarre= new CommandeCarre(i);
    commandeCarre.execute();
    //CommandePrint commandePrint = new CommandePrint(i);
    //commandePrint.execute();
    System.out.println(i.dessin);
  }


}