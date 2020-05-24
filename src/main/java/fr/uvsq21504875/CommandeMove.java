package fr.uvsq21504875;

public class CommandeMove implements Commande {

  /**
   * Interpreteur.
   */
  private Interpreteur inter;

  /**
   * Constructeur de la commande Move.
   *
   * @param interpreteur L'interpreteur.
   */
  public CommandeMove(final Interpreteur interpreteur) {
    this.inter = interpreteur;
  }

  /**
   * Méthode de recheche d'un objet dans le dessin.
   *
   * @param name L'objet a rechercher.
   * @return L'objet trouvé.
   */
  public Forme findComposite(final String name) {
    CompositeForme forme;
    for (Forme f : inter.dessin) {
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
   * Fonction d'exécution de la commande Move.
   */
  @Override
  public void execute() {
    if (inter.parametersT.length!=3) {
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    } else {
        Forme f = findComposite(inter.parametersT[0]);
        if (f != null) {
          try {
            int a = Integer.parseInt(inter.parametersT[1]);
            int b = Integer.parseInt(inter.parametersT[2]);
            inter.undo.push(inter.dessin);
            inter.redo.clear();
            f.move(a, b);
          } catch(Exception e) {
              e.printStackTrace();
          }
      }


    }
  }
}
