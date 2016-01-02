/**
 * La classe AffichageAstres a but de faire runner un thread et d'appeler la m&eacute;thode repaint
 * de la classe Fenetre en fonction du temps
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
     * M&eacute;thode permettant de d&eacute;marrer le Thread et de le faire Runner.
     * Le Thread s'arr&ecirc;te tout les 1/100 de seconde afin de mettre &agrave; jour
     * l'affichage &agrave; l'aide de la m&eacute;thode repaint de
     * la classe Fenetre en fonction du temps t
     * @see Fenetre#repaint(float)
     */
    public void run() {
        float t=0;        while(true){
            try {
                this.sleep(10);
                t+=1;
                fenetre.repaint(t);
            } catch(InterruptedException e){}
        }
    }

}
