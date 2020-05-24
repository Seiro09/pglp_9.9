package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeRedo implements Commande {
  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur;

  /**
   * Constructeur de la commande Redo.
   *
   * @param interpreteur l'interpreteur.
   */
  public CommandeRedo(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Fonction d'exécution de la commande Redo.
   */
  @Override
  public void execute() {
    interpreteur.undo.push(new ArrayList<>(interpreteur.dessin));
    interpreteur.dessin = interpreteur.redo.pop();
  }
}
