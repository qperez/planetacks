import java.util.ArrayList;

/**
 * <b>Classe permettant de mod&eacute;liser une Etoile.</b>
 * Une Etoile est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * <li>Un nom d'image</li>
 * <li>Une position X.</li>
 * <li>Une position Y.</li>
 * </ul>
 */
public class Etoile extends Astre {

    /**
     * Constructeur Etoile.
     * <p>
     * Constructeur vide n&eacute;cessaire pour la sauvegarde XML
     * </p>
     */
    public Etoile(){
        super();
    }

    /**
     * Constructeur Etoile.
     * <p>
     * A la construction d'un objet Etoile, l'Etoile est initialis&eacute;e
     * avec les param&egrave;tres du constructeur.
     * </p>
     *
     * @param nom Le nom de l'étoile
     * @param nomImage Le nom de l'image correspondant à l'Etoile
     * @param positionX la position en X de l'Etoile
     * @param positionY la position en Y de l'Etoile
     * @see Astre#nom
     * @see Astre#nomImage
     * @see Etoile#positionX
     * @see Etoile#positionY
     */
    public Etoile(String nom, String nomImage, int positionX, int positionY) {
        super(nom, nomImage, positionX, positionY);
    }

    /**
     * Constructeur Etoile.
     * <p>
     * A la construction d'un objet Etoile, l'Etoile est initinitialis&eacute;e
     * avec les param&egrave;tres du constructeur.
     * </p>
     *
     * @param nom Le nom de l'&eacute;toile
     * @param nomImage Le nom de l'image correspondant &agrave; l'Etoile
     * @param positionX la position en X de l'Etoile
     * @param positionY la position en Y de l'Etoile
     * @param listeSatellites la liste de Satellite gravitant autour de l'Etoile
     * @see Astre#nom
     * @see Astre#nomImage
     * @see Etoile#positionX
     * @see Etoile#positionY
     * @see Astre#listeSatellites
     */
    public Etoile(String nom, String nomImage, int positionX, int positionY, ArrayList<Satellite> listeSatellites) {
        super(nom, nomImage, positionX, positionY);
        this.setListeSatellites(listeSatellites);
    }

    /**
     * Retourne le nom de l'&eacute;toile
     * @return String le nom de l'&eacute;toile
     */
    public String toString() {
        return getNom();
    }
}


