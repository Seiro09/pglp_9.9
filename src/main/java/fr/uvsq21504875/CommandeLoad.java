package fr.uvsq21504875;

import java.util.Scanner;

public class CommandeLoad implements Commande {

  private Interpreteur interpreteur;
  public CommandeLoad(Interpreteur interpreteur) {
    this.interpreteur=interpreteur;
  }

  @Override
  public void execute() {
    AfficheMessage a = new AfficheMessage();
    a.affiche("Charger ?");
    String reponseUtilisateur;
    Scanner sc;
    do {
      sc = new Scanner(System.in);
      reponseUtilisateur= sc.nextLine();
    }while (!(reponseUtilisateur.equals("Oui"))||!(reponseUtilisateur.equals("Non")));
    if (reponseUtilisateur.equals("Oui")) {
      interpreteur.dessin.addAll(DAOFactory.getCercleDAO().findAll());
      interpreteur.dessin.addAll(DAOFactory.getCarreDAO().findAll());
      interpreteur.dessin.addAll(DAOFactory.getRectangleDAO().findAll());
      interpreteur.dessin.addAll(DAOFactory.getTriangleDAO().findAll());
    }
    System.exit(12);
  }
}
