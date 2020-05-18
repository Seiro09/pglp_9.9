package fr.uvsq21504875;

public class CommandeGroupe implements Commande {

  private Interpreteur interpreteur;

  public CommandeGroupe(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {

  }
}
