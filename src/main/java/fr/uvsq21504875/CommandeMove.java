package fr.uvsq21504875;

import java.util.List;

public class CommandeMove implements Commande {

  private Interpreteur inter;
  public CommandeMove(Interpreteur interpreteur) {
    this.inter=interpreteur;
  }

  public Forme findComposite(String name){
    CompositeForme forme=null;
    for (Forme f : inter.dessin){
      if (f.getNom().equals(name)) return f;
      else if(f instanceof CompositeForme){
        forme = (CompositeForme) f;
        for (Forme f1 : forme.children){
          if (f1.getNom().equals(name)) return f1;
        }
      }
    }
    return null;
  }

  @Override
  public void execute() {
    if (inter.parametersT.length!=3){
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    }
    else{
     Forme f = findComposite(inter.parametersT[0]);
      if (f!=null){
        try{
          int a = Integer.parseInt(inter.parametersT[1]);
          int b = Integer.parseInt(inter.parametersT[2]);
          inter.undo.push(inter.dessin);
          inter.redo.clear();
          f.move(a,b);
        }catch(Exception e){
          e.printStackTrace();
        }
      }


    }
  }
}
