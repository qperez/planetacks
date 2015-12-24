import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by quentin on 24/12/15.
 */
public abstract class Controleur implements ActionListener {

    protected Fenetre fenetre;

    public Controleur(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public abstract void actionPerformed(ActionEvent e);
}
