package fr.uvsq21504875;

import java.util.Scanner;

public class CommandeQuit implements Commande {

  private Interpreteur interpreteur;

  public CommandeQuit(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    AfficheMessage a = new AfficheMessage();
    a.affiche("Sauvegarder ?");
    String reponseUtilisateur;
    Scanner sc;
    do {
      sc = new Scanner(System.in);
      reponseUtilisateur= sc.nextLine();
    }while (!(reponseUtilisateur.equals("Yes"))||!(reponseUtilisateur.equals("No")));
    if (reponseUtilisateur.equals("Yes")) {
      CommandeSave commandeSave = new CommandeSave(interpreteur);
      commandeSave.execute();
    }
    System.exit(12);
  }
}
