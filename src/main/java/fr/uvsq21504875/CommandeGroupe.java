package fr.uvsq21504875;

public class CommandeGroupe implements Commande {

  private Interpreteur interpreteur;

  public CommandeGroupe(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  public Forme findComposite(String name){
    CompositeForme forme;
    for (Forme f : interpreteur.dessin){
      if (f.getNom().equals(name)) {
        Forme f_tmp = f;
        interpreteur.dessin.remove(f);
        return f_tmp;
      }
      else if(f instanceof CompositeForme){
        forme = (CompositeForme) f;
        for (Forme f1 : forme.children){
          if (f1.getNom().equals(name)){
            Forme f_tmp = f;
            forme.children.remove(f);
            return f_tmp;
          }
        }
      }
    }
    return null;
  }

  @Override
  public void execute() {
    Forme groupe = findComposite(interpreteur.parametersT[0]);
    CompositeForme groupeFinal= new CompositeForme(interpreteur.parametersT[0]);
    if (groupe instanceof CompositeForme) groupeFinal= (CompositeForme) groupe;
    else groupeFinal.add(groupe);
    for (int i = 1;i<interpreteur.parametersT.length;i++){
      groupeFinal.add(findComposite(interpreteur.parametersT[i]));
    }
    //groupeFinal.print();
    //interpreteur.dessin.add(groupeFinal);
  }
}
