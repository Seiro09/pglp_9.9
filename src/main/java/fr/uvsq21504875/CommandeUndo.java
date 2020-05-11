package fr.uvsq21504875;

public class CommandeUndo implements Commande {

  private Interpreteur interpreteur;

  public CommandeUndo(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    interpreteur.redo.push(interpreteur.dessin);
    interpreteur.dessin=interpreteur.undo.pop();
  }
}
