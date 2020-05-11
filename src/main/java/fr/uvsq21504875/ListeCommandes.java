package fr.uvsq21504875;

import java.util.HashMap;

public class ListeCommandes {
  protected HashMap<String,Commande> set = new HashMap<>();
  private String[] parametersT;
  private CompositeForme cf;
  public ListeCommandes(){
    set.put("Cercle",new CommandeCercle(parametersT,cf));
  }

  public void setParametersT(String[] parametersT) {
    this.parametersT = parametersT;
  }
}
