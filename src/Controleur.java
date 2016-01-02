import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by quentin on 24/12/15.
 */
/**
 * <b>Classe permettant de cr&eacute;er tout type de contr&ocirc;leurs</b>
 * un Controleur est caract&eacute;ris&eacute; pas les informations suivantes :
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
     * &Agrave; la construction d'un objet Fenetre, la Fenetre est initinitialis&eacute;e
     * avec commme param&egrave;tres un Modele.
     * </p>
     *
     * @param fenetre la Fenetre servant &agrave; la construction
     * @param modele le modele correspondant &agrave; la Fenetre
     * @see Controleur#fenetre
     * @see Controleur#modele
     */
    public Controleur(Fenetre fenetre, Modele modele) {
        this.fenetre = fenetre;
        this.modele = modele;
    }

    /**
     * M&eacute;thode devant &ecirc;tre obligatoirement impl&eacute;ment&eacute;e pour utiliser le Controleur
     * @param e l'ActionEvent en provenance du listener
     */
    public abstract void actionPerformed(ActionEvent e);
}
