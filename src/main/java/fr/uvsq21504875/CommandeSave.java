package fr.uvsq21504875;

import java.util.List;

public class CommandeSave implements Commande {
  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur;

  /**
   * Constructeur de la commande Save.
   *
   * @param interpreteur l'interpreteur.
   */
  public CommandeSave(final Interpreteur interpreteur) {
  this.interpreteur = interpreteur;
  }

  /**
   * Fonction de sauvegarde d'un dessin (aplatit le dessin).
   * @param list La liste à sauvegarder.
   */
  public void saveList(final List<Forme> list) {
    for (Forme f : list) {
      if (f instanceof Cercle) {
        DAOFactory.getCercleDAO().create((Cercle) f);
      } else if (f instanceof Triangle) {
        DAOFactory.getTriangleDAO().create((Triangle) f);
      } else if (f instanceof Carre) {
        DAOFactory.getCarreDAO().create((Carre) f);
      } else if (f instanceof Rectangle) {
        DAOFactory.getRectangleDAO().create((Rectangle) f);
      } else if (f instanceof CompositeForme) {
        saveList(((CompositeForme) f).children);
      }
    }
  }

  /**
   * Fonction d'exécution de la commande Save.
   */
  @Override
  public void execute() {
    saveList(interpreteur.dessin);
  }
}
