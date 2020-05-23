package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeCarre implements Commande {

  private Interpreteur interpreteur;

  public CommandeCarre(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    if (interpreteur.parametersT.length != 4) {
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
        Carre c1 = new Carre(interpreteur.parametersT[0],a,b,c);
        interpreteur.dessin.add(c1);
        //c1.print();
      }catch(NumberFormatException e){
        e.printStackTrace();
      }
    }
  }
}
