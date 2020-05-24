package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeRectangle implements Commande {

  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur;
  /**
   * Constructeur de la commande Rectangle.
   *
   * @param interpreteur l'interpreteur.
   */
  public CommandeRectangle(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Commande d'exécution de la commande Rectangle.
   */
  @Override
  public void execute() {
    if (interpreteur.parametersT.length != 5) {
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    } else {
        try {
          interpreteur.undo.push(new ArrayList<>(interpreteur.dessin));
          interpreteur.redo.clear();
          int a = Integer.parseInt(interpreteur.parametersT[1]);
          int b = Integer.parseInt(interpreteur.parametersT[2]);
          int c = Integer.parseInt(interpreteur.parametersT[3]);
          int d = Integer.parseInt(interpreteur.parametersT[4]);
          Rectangle r1 = new Rectangle(interpreteur.parametersT[0], a, b, c, d);
          interpreteur.dessin.add(r1);
          r1.print();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
  }
}
