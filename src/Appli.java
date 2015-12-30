/**
 * Created by quentin on 27/11/15.
 */
public class Appli {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Modele modele = new Modele();
                Fenetre fenetre = new Fenetre(modele);
                Etoile soleil = new Etoile("Soleil", "exit.png", 100, 100);
                modele.ajouterEtoile(soleil);
                Satellite satellite = new Satellite("s", "exit.png", 2, 2, 2, soleil);
                modele.ajouterEtoile(new Etoile("Soleil2", "exit.png", 100, 100));
            }
        });
        System.out.println("Hello world, it's was the first commit in the space because ponies are the most beautiful");
    }
}