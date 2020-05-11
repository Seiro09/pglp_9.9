package fr.uvsq21504875;

/**
 *
 */
public class CommandeCercle implements Commande{
  private String[] parameters;
  private CompositeForme groupe;
  public CommandeCercle(String[] parameters, CompositeForme groupe){
    this.parameters=parameters;
    this.groupe=groupe;
  }

  @Override
  public void execute() {
    if (this.parameters.length != 4) {
      AfficheMessage a = new AfficheMessage();
      a.affiche("Erreur sur le nombre de paramètres.");
    }
    else{
      try {
        int a = Integer.parseInt(this.parameters[1]);
        int b = Integer.parseInt(this.parameters[2]);
        double c = Double.parseDouble(this.parameters[3]);
        groupe.add(new Cercle(parameters[0],a,b,c));
      }catch(NumberFormatException e){
        e.printStackTrace();
      }
    }
  }
}
