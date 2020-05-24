package fr.uvsq21504875;

public class CommandeGroupe implements Commande {

  /**
   * Interpreteur.
   */
  private Interpreteur interpreteur;

  /**
   * Constructeur de la commande Groupe.
   *
   * @param interpreteur l'interpreteur.
   */
  public CommandeGroupe(final Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Méthode de recheche d'un objet dans le dessin.
   *
   * @param name L'objet a rechercher.
   * @return L'objet trouvé.
   */
  public Forme findComposite(final String name) {
    CompositeForme forme;
    for (Forme f : interpreteur.dessin) {
      if (f.getNom().equals(name)) {
        return f;
      } else if (f instanceof CompositeForme) {
         forme = (CompositeForme) f;
         for (Forme f1 : forme.children) {
           if (f1.getNom().equals(name)) {
             return f1;
           }
         }
      }
    }
    return null;
  }

  /**
   * Fonction d'exécution de la commande Groupe.
   */
  @Override
  public void execute() {
    Forme groupe = findComposite(interpreteur.parametersT[0]);
    CompositeForme groupeFinal =
        new CompositeForme(interpreteur.parametersT[0]);
    if (groupe instanceof CompositeForme) {
      groupeFinal = (CompositeForme) groupe;
    } else {
      groupeFinal.add(groupe);
    }
    for (int i = 1; i < interpreteur.parametersT.length; i++) {
      groupeFinal.add(findComposite(interpreteur.parametersT[i]));
    }
    //groupeFinal.print();
    interpreteur.dessin.add(groupeFinal);
  }
}
