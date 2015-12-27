import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by quentin on 24/12/15.
 */
/**
 * <b>Classe permettant de créer tout type de contrôleurs</b>
 * un Controleur erst caractérisé pas lesd informations suivantes :
 * <ul>
 * <li>Une Fenetre.</li>
 * <li>Un Modele.</li>
 * </ul>
 */
public abstract class Controleur implements ActionListener {

    protected Fenetre fenetre;
    protected Modele modele;

    /**
     * Constructeur Controleur.
     * <p>
     * A la construction d'un objet Fenetre, la Fenetre est initinitialis&eacute;e
     * avec commme param&egrave;tres un Modele.
     * </p>
     *
     * @param fenetre la Fenetre servant à la construction
     * @param modele le modele correspondant à la Fenetre
     * @see Controleur#fenetre
     * @see Controleur#modele
     */
    public Controleur(Fenetre fenetre, Modele modele) {
        this.fenetre = fenetre;
        this.modele = modele;
    }

    /**
     * Méthode devant être obligatoirement implémentée pour utiliser le Controleur
     * @param e l'ActionEvent en provenance du listener
     */
    public abstract void actionPerformed(ActionEvent e);
}
