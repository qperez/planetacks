import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <b>Classe permettant de mod&eacute;liser une étoile.</b>
 * Une Etoile est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * <li>Une position X.</li>
 * <li>Une position Y.</li>
 * </ul>
 */
public class Etoile extends Astre {

    /**
     * Constructeur Etoile.
     * <p>
     * A la construction d'un objet Etoile, l'Etoile est initinitialis&eacute;e
     * avec les param&egrave;tres du constructeur.
     * </p>
     *
     * @param nom Le nom de l'étoile
     * @see Astre#nom
     * @see Etoile#positionX
     * @see Etoile#positionY
     */

    public Etoile(String nom, String nomImage, int positionX, int positionY) {
        super(nom, nomImage, positionX, positionY);
    }

    public Etoile(String nom, String nomImage, int positionX, int positionY, ArrayList<Satellite> listeSatellites) {
        super(nom, nomImage, positionX, positionY);
        this.listeSatellites = listeSatellites;
    }

    public String toString() {
        return getNom();
    }
}


