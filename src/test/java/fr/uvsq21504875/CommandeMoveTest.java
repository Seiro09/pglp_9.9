package fr.uvsq21504875;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandeMoveTest {

  @Test
  public void findListe() throws Exception {
    Cercle c1 = new Cercle("c1",0,0,15);
    Cercle c2 = new Cercle("c2",0,10,16);
    CompositeForme cf = new CompositeForme("cf1");
    cf.add(c1);
    cf.add(c2);
    Cercle c3= new Cercle("c3",10,10,17);
    CompositeForme cf2= new CompositeForme("cf2");
    cf2.add(c3);
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "50", "64"});
    i.dessin.add(cf);
    i.dessin.add(cf2);
    CommandeMove commmandeMove = new CommandeMove(i);
    Forme f = commmandeMove.findComposite("cf1");
    f.print();
  }

  @Test
  public void execute() throws Exception {
    Interpreteur i = new Interpreteur();
    i.setParametersT(new String[]{"c4", "50", "50", "64"});
    CommandeCercle commandeCercle = new CommandeCercle(i);
    commandeCercle.execute();
    i.setParametersT(new String[]{"c4", "50", "50"});
    CommandeMove commandeMove = new CommandeMove(i);
    commandeMove.execute();
    CommandePrint commandePrint = new CommandePrint(i);
    commandePrint.execute();
  }

}