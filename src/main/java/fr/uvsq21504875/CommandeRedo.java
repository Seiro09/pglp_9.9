package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeRedo implements Commande {

  private Interpreteur interpreteur;

  public CommandeRedo(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    interpreteur.undo.push(new ArrayList<>(interpreteur.dessin));
    interpreteur.dessin=interpreteur.redo.pop();
  }
}
