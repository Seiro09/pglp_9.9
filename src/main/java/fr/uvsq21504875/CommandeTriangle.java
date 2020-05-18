package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeTriangle implements Commande {

  private Interpreteur interpreteur;

  public CommandeTriangle(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    if (interpreteur.parametersT.length != 7) {
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    }
    else{
      try {
        interpreteur.undo.push(new ArrayList<>(interpreteur.dessin));
        interpreteur.redo.clear();
        int a = Integer.parseInt(interpreteur.parametersT[1]);
        int b = Integer.parseInt(interpreteur.parametersT[2]);
        int c = Integer.parseInt(interpreteur.parametersT[3]);
        int d = Integer.parseInt(interpreteur.parametersT[4]);
        int e = Integer.parseInt(interpreteur.parametersT[5]);
        int f = Integer.parseInt(interpreteur.parametersT[6]);
        Triangle t1 = new Triangle(interpreteur.parametersT[0],a,b,c,d,e,f);
        interpreteur.dessin.add(t1);
        t1.print();
      }catch(NumberFormatException e){
        e.printStackTrace();
      }
    }
  }
}
