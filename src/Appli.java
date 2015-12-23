import java.io.IOException;

/**
 * Created by quentin on 27/11/15.
 */
public class Appli {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Modele modele = new Modele();
                Fenetre fen = new Fenetre(modele);
            }
        });
        System.out.println("Hello world, it's was the first commit in the space because purple ponies are the most beautiful !");
        /*Astre astre = new Astre("AstroTest", 15 ,50);
        Etoile etoile = new Etoile("soleil", 150, 200);
        Satellite terre = new Satellite("Terre", 14, 25, 3600, etoile);

        terre.calculPositionSatelliteX(25);*/
    }
}