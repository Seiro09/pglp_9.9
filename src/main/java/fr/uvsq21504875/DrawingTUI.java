package fr.uvsq21504875;

public class DrawingTUI {

  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur = new Interpreteur();


  /**
   * Méthode d'analyse de l"entrée utilisateur.
   *
   * @param s L'entrée utilisateur.
   * @return La commmande associé ou null.
   */
  public Commande nextCommande(final String s) {
    String type;
    if (s.contains("(")) {
      type = s.substring(0, s.indexOf("("))
          .replace(" ", "");
      String parameters = s.substring(
          s.indexOf("("), s.length()).replace(" ", "");
      this.interpreteur.setParametersT(
          parameters.replace("(", "")
              .replace(")", "").split(","));
    } else {
      type = s;
    }
    type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
    Commande c = interpreteur.set.get(type);
    return c;
  }

  /**
   * Méthode d'affichage du contenu du dessin.
   */
  public void print() {
    interpreteur.print();
  }
}
