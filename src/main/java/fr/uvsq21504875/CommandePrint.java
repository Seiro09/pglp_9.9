package fr.uvsq21504875;

import java.util.List;

public class CommandePrint implements Commande {

  private Interpreteur inter;
  public CommandePrint(Interpreteur interpreteur) {
    this.inter=interpreteur;
  }

  @Override
  public void execute() {
    for(Forme forme : inter.dessin){
      forme.print();
    }
  }
}
