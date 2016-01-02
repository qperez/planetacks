/**
 * Created by quentin on 31/12/15.
 * La classe AffichageAstres a pour mission de faire runner un thread et d'appeler la méthode repaint
 * de la classe Fenetre en fonction du temps
 * en fonction du temps
 */
public class AffichageAstres extends Thread {

    private Fenetre fenetre;

    /**
     * Constructeur AffichageAstres.
     * <p>
     * &Agrave; la construction le constructeur est initialis&eacute; avec la Fenetre.
     * </p>
     * @param fenetre Fenetre
     */
    public AffichageAstres(Fenetre fenetre){
        this.fenetre = fenetre;
    }

    /**
     * Méthode permettant de démarrer le Thread et de le faire Runner.
     * Le Thread s'arrête tout les 1/100 de seconde afin de mettre à jour
     * l'affichage à l'aide de la méthode repaint de
     * la classe Fenetre en fonction du temps t
     * @see Fenetre#repaint(float)
     */
    public void run() {
        float t=0;        while(true){
            try {
                this.sleep(10);
                t+=1;
               //System.out.println(t);
                fenetre.repaint(t);
            } catch(InterruptedException e){}
        }
    }

}
