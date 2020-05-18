package fr.uvsq21504875;

import java.util.ArrayList;

public class CommandeCercle implements Commande{
  private Interpreteur inter;
  public CommandeCercle(Interpreteur interpreteur){
    this.inter=interpreteur;
  }

  @Override
  public void execute() {
    if (inter.parametersT.length != 4) {
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    }
    else{
      try {
        inter.undo.push(new ArrayList<>(inter.dessin));
        inter.redo.clear();
        int a = Integer.parseInt(inter.parametersT[1]);
        int b = Integer.parseInt(inter.parametersT[2]);
        double c = Double.parseDouble(inter.parametersT[3]);
        Cercle c1 = new Cercle(inter.parametersT[0],a,b,c);
        inter.dessin.add(c1);
        c1.print();
      }catch(NumberFormatException e){
        e.printStackTrace();
      }
    }
  }
}
