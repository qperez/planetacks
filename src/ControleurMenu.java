import java.awt.event.ActionEvent;

/**
 * Created by quentin on 24/12/15.
 */
public class ControleurMenu extends Controleur {

    public ControleurMenu(Fenetre fenetre, Modele modele){
        super(fenetre, modele);
    }

    public void actionPerformed(ActionEvent e){
        if(fenetre.getItemQuitter() == e.getSource()) {
            System.exit(0);
        }

        else if (fenetre.getItemNouveauSysteme() == e.getSource()) {

        }

        else if (fenetre.getItemSauvegarder() == e.getSource()) {
            
        }

        else if (fenetre.getItemRestaurer() == e.getSource()) {

        }
    }
}
