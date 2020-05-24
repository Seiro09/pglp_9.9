package fr.uvsq21504875;

public class CommandeUndo implements Commande {

  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur;

  /**
   * Constructeur de la commande Undo.
   *
   * @param interpreteur Interpreteur.
   */
  public CommandeUndo(final Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Fonction d'exécution de la commande Undo.
   */
  @Override
  public void execute() {
    interpreteur.redo.push(interpreteur.dessin);
    interpreteur.dessin = interpreteur.undo.pop();
  }
}
