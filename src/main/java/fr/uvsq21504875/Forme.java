package fr.uvsq21504875;

public interface Forme {
  /**
   * Fonction de déplacement.
   *
   * @param x Abscisse
   * @param y Ordonnée
   */
  void move(int x, int y);

  /**
   * Affichage de la forme.
   */
  void print();

  /**
   * Getter du Nom.
   *
   * @return Le nom de la forme.
   */
  String getNom();
}
