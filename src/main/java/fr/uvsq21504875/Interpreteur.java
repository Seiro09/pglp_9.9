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
    set.put("Move", new CommandeMove(this));
    set.put("Print", new CommandePrint(this));
    set.put("Undo", new CommandeUndo(this));
    set.put("Redo", new CommandeRedo(this));
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