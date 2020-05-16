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
    while (true) {
      sc = new Scanner(System.in);
      reponseUtilisateur= sc.nextLine();
      if (reponseUtilisateur.compareTo("Oui")==0) {
        CommandeSave commandeSave = new CommandeSave(interpreteur);
        commandeSave.execute();
        System.exit(17);
      }
      if (reponseUtilisateur.compareTo("Non")==0){
        System.exit(18);
      }
    }

  }
}
