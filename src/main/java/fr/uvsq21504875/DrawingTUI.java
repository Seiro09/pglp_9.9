package fr.uvsq21504875;

public class DrawingTUI {

  private ListeCommandes listeCommandes = new ListeCommandes();


  public Commande nextCommande(String s){
    //String nomForme = s.substring(0,s.indexOf("=")).replace(" ","");
    //String type = s.substring(s.indexOf("=")+1,s.indexOf("(")).replace(" ","");

    String type = s.substring(0,s.indexOf("(")).replace(" ","");
    String parameters=s.substring(s.indexOf("("),s.length()).replace(" ","");
    this.listeCommandes.setParametersT(parameters.replace("(","").replace(")","").split(","));

    type= type.substring(0,1).toUpperCase()+type.substring(1).toLowerCase();
    Commande c = listeCommandes.set.get(type);
    return c;
  }

  public void print(){
    //afficher tout le dessin
  }
}
