package fr.uvsq21504875;

import java.util.*;


public class Interpreteur {
  protected HashMap<String,Commande> set = new HashMap<>();
  protected String[] parametersT;
  protected List<Forme> dessin = new ArrayList<>();
  protected Stack<List<Forme>> undo = new Stack<>();
  protected Stack<List<Forme>> redo = new Stack<>();


  public Interpreteur(){
    set.put("Cercle",new CommandeCercle(this));
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
    set.put("Load",new CommandeLoad(this));
  }

  public void setParametersT(String[] parametersT) {
    this.parametersT = parametersT;
  }

  public void print() {
    for(Forme forme : this.dessin){
      forme.print();
    }
  }

  public void undo(){
  }
}
