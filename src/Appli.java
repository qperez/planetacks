/**
 * Created by quentin on 27/11/15.
 */
public class Appli {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Modele modele = new Modele();
                Fenetre fenetre = new Fenetre(modele);

                /*en.affiche(fenetre);
                soleil.affiche(fenetre);*/
            }
        });
        System.out.println("Hello world, it's was the first commit in the space because ponies are the most beautiful");
    }
}