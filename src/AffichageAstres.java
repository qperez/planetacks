/**
 * Created by quentin on 31/12/15.
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
                fenetre.repaint((float)1.0);
            }catch(InterruptedException e){

            }
        }
    }

}
