package fr.uvsq21504875;

/**
 * Hello world!
 *
 */
public enum DrawingApp
{
    DRAWING_APP;

    private void run(){
        DrawingTUI drawingTUI = new DrawingTUI();
        while(true){
            Commande commande = drawingTUI.nextCommande();
            commande.execute();
        }

    }

    public static void main(String[] args){
        DRAWING_APP.run();
    }
}
