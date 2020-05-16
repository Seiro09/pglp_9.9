package fr.uvsq21504875;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public enum DrawingApp
{
    DRAWING_APP;

    private void run(){
        DrawingTUI drawingTUI = new DrawingTUI();
        Scanner sc;
        while(true){
            sc = new Scanner(System.in);
            Commande commande = drawingTUI.nextCommande(sc.nextLine());
            commande.execute();
        }

    }

    public static void main(String[] args){
        DRAWING_APP.run();
    }
}
