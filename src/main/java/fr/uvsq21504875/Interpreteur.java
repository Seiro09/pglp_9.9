package fr.uvsq21504875;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Interpreteur {
  /**
   * Liste de commandes.
   */
  protected HashMap<String, Commande> set = new HashMap<>();
  /**
   * Paramètres entrés par l'utilisateur.
   */
  protected String[] parametersT;
  /**
   * Dessin crée par l'utilisateur.
   */
  protected List<Forme> dessin = new ArrayList<>();
  /**
   * Liste d'actions faites par l'utilisateur.
   */
  protected Stack<List<Forme>> undo = new Stack<>();
  /**
   * Liste d'actions faites par l'utilisateur.
   */
  protected Stack<List<Forme>> redo = new Stack<>();


  /**
   * Constructeur de l'interpreteur.
   */
  public Interpreteur() {
    set.put("Cercle", new CommandeCercle(this));
    set.put("Triangle", new CommandeTriangle(this));
    set.put("Carre", new CommandeCarre(this));
    set.put("Rectangle", new CommandeRectangle(this));
    set.put("Move", new CommandeMove(this));
    set.put("Groupe", new CommandeGroupe(this));
    set.put("Print", new CommandePrint(this));
    set.put("Undo", new CommandeUndo(this));
    set.put("Redo", new CommandeRedo(this));
    set.put("Quit", new CommandeQuit(this));
    set.put("Save", new CommandeSave(this));
    set.put("Load", new CommandeLoad(this));
  }

  /**
   * Setter des paramètres de l'utilisateur.
   *
   * @param parametersT Les paramètres entrés par l'utilsateur.
   */
  public void setParametersT(final String[] parametersT) {
    this.parametersT = parametersT;
  }

  /**
   * Affichage du dessin.
   */
  public void print() {
    for (Forme forme : this.dessin) {
      forme.print();
    }
  }

}
