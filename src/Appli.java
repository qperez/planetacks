/**
 * <b>Classe principale servant de point d'entrée à l'application</b>
 */
public class Appli {
    /**
     * M&eacute;thode principale
     * @param args Arguments de l'application
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Modele modele = new Modele();
                Fenetre fenetre = new Fenetre(modele);
            }
        });
    }
}