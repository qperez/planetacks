import java.awt.event.ActionEvent;

/**
 * Created by quentin on 24/12/15.
 */
public class ControleurMenu extends Controleur {

    public ControleurMenu(Fenetre fenetre){
        super(fenetre);
    }

    public void actionPerformed(ActionEvent e){

        if(fenetre.itemQuitter == e.getSource()) {
            System.exit(0);
        }
    }
}
