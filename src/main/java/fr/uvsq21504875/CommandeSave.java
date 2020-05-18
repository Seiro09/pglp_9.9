package fr.uvsq21504875;

import java.util.List;

public class CommandeSave implements Commande {
  private Interpreteur interpreteur;

  public CommandeSave(Interpreteur interpreteur) {
  this.interpreteur=interpreteur;
  }

  public void saveList(List<Forme> list){
    for (Forme f : list){
      if (f instanceof Cercle) DAOFactory.getCercleDAO().create((Cercle) f);
      else if (f instanceof Triangle) DAOFactory.getTriangleDAO().create((Triangle) f);
      else if (f instanceof Carre) DAOFactory.getCarreDAO().create((Carre) f);
      else if (f instanceof Rectangle) DAOFactory.getRectangleDAO().create((Rectangle) f);
      else if (f instanceof CompositeForme) saveList(((CompositeForme) f).children);
    }
  }

  @Override
  public void execute() {
    saveList(interpreteur.dessin);
  }
}
