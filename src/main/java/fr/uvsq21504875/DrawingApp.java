package fr.uvsq21504875;

import java.util.Scanner;

public enum DrawingApp {
    /**
     * Variable d'environnement.
     */
    DRAWING_APP;

    /**
     * Code principal de l'application.
     */
    private void run() {
        DrawingTUI drawingTUI = new DrawingTUI();
        Scanner sc;
        while (true) {
          try {
            sc = new Scanner(System.in);
            Commande commande = drawingTUI.nextCommande(sc.nextLine());
            commande.execute();
          } catch (NullPointerException e) {
              AfficheMessage afficheMessage = new AfficheMessage();
              afficheMessage.affiche("Commande non Valide");
          }
        }
    }

    /**
     * Fonction principale du code de l'application.
     */
    public static void main(String[] args) {
        DRAWING_APP.run();
    }
}
