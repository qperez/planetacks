/**
 * Created by quentin on 31/12/15.
 * La classe AffichageAstres a pour mission de faire runner un thread et d'appellé la méthode repaint
 * en fonction du temps
 */

public class AffichageAstres extends Thread {

    private Fenetre fenetre;

    public AffichageAstres(Fenetre fenetre){

        this.fenetre = fenetre;
    }

    public void run(){
        float t=0;
        System.out.println("Démarrage thread");
        while(true){
            try{
                this.sleep(10);
                t+=1;
               //System.out.println(t);
                fenetre.repaint(t);
            }catch(InterruptedException e){

            }
        }
    }

}
