package fr.uvsq21504875;

public class DrawingTUI {

  private Interpreteur interpreteur = new Interpreteur();


  public Commande nextCommande(String s){
    String type;
    if(s.contains("(")){
      type = s.substring(0,s.indexOf("(")).replace(" ","");
      String parameters=s.substring(s.indexOf("("),s.length()).replace(" ","");
      this.interpreteur.setParametersT(parameters.replace("(","").replace(")","").split(","));
    }
    else{
      type=s;
    }
    type= type.substring(0,1).toUpperCase()+type.substring(1).toLowerCase();
    Commande c = interpreteur.set.get(type);
    return c;
  }

  public void print(){
    interpreteur.print();
  }
}
