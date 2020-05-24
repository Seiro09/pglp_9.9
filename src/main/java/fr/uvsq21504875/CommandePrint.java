package fr.uvsq21504875;

public class CommandePrint implements Commande {

  /**
   * Interpreteur.
   */
  private Interpreteur inter;

  /**
   * Constructeur de la commande Print.
   *
   * @param interpreteur l"interpreteur.
   */
  public CommandePrint(final Interpreteur interpreteur) {
    this.inter = interpreteur;
  }

  /**
   * Fonction d'exécution de la commande Print.
   */
  @Override
  public void execute() {
    for (Forme forme : inter.dessin) {
      forme.print();
    }
  }
}
