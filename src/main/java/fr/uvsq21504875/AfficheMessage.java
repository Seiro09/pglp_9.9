package fr.uvsq21504875;

public class AfficheMessage implements Affichage {
  /**
   * Méthode d'affichage d'un message.
   *
   * @param s LA message à afficher.
   */
  @Override
  public void affiche(final String s) {
    System.out.println(s);
  }
}
