package fr.uvsq21504875;

import java.util.ArrayList;
import java.util.List;

public class CompositeForme implements Forme {
  /**
   * Nom du groupe.
   */
  private String nom;
  /**
   * Fils du noeud.
   */
  protected List<Forme> children = new ArrayList<>();

  /**
   * Constrcteur de groupe.
   *
   * @param nom Nom du Groupe.
   */
  public CompositeForme(final String nom) {
    this.nom = nom;
  }

  /**
   * Ajout d'une Forme au Groupe.
   *
   * @param f La forme à ajouter.
   */
  public void add(final Forme f) {
    children.add(f);
  }

  /**
   * Suppression d'une Forme du Groupe.
   *
   * @param f La forme à supprimer.
   */
  public void remove(final Forme f) {
    children.remove(f);
  }

  /**
   * Méthode de déplacement des formes du Groupe.
   *
   * @param x Le déplacement souhaité sur x.
   * @param y Le déplacement souhaité sur y.
   */
  public void move(final int x, final int y) {
    for (Forme f : children) {
      f.move(x, y);
    }
  }

  /**
   * Méthode d'affichage des membres du Groupe.
   */
  public void print() {
    for (Forme f : children) {
      f.print();
    }
  }

  /**
   * Getter du Nom.
   *
   * @return Le nom enregistré.
   */
  @Override
  public String getNom() {
    return nom;
  }

  /**
   * Setter du Nom.
   *
   * @param nom Le nom souhaité.
   */
  public void setNom(final String nom) {
    this.nom = nom;
  }
}
