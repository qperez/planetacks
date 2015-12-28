import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>Classe permettant de mod&eacute;liser un astre.</b>
 * Un Astre est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * </ul>
 */
public class Astre {

    private String nom;
    private String nomImage;
    private int positionX;
    private int positionY;
    ArrayList<Satellite> listeSatellites;

    /**
     * Constructeur Astre.
     * <p>
     * A la construction d'un objet Astre, l'Astre est initinitialisé
     * avec les paramètres du constructeur.
     * </p>
     *
     * @param nom Le nom de l'astre
     * @param positionX La position X de l'Astre
     * @param positionY La position Y de l'Astre
     *
     * @see Astre#nom
     * @see Astre#positionX
     * @see Astre#positionY
     */
    public Astre(String nom, String nomImage, int positionX, int positionY){
        this.nom = nom;
        this.nomImage = nomImage;
        this.positionX = positionX;
        this.positionY = positionY;
        this.listeSatellites = new ArrayList<Satellite>();
    }

    /**
     * Retourne le nom de l'astre
     * @return Nom de l'astre
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom de l'astre.
     *
     * @param nom
     *            Le nouveau nom de l'astre.
     *
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nom de l'image de l'astre
     * @return Nom de l'image de l'astre
     */
    public String getNomImage() {
        return nomImage;
    }

    public DefaultMutableTreeNode getArbreSatellites() {
        Iterator<Satellite> it = this.getListeSatellites().iterator();
        DefaultMutableTreeNode branche = new DefaultMutableTreeNode(this);
        while (it.hasNext()) {
            Satellite s = it.next();
            branche.add(s.getArbreSatellites());
        }
        return branche;
    }

    /**
     * Retourne la position X de l'étoile
     * @return Position de X de l'étoile
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Met &agrave; jour la position X de l'&eacute;toile.
     *
     * @param positionX
     *            La nouvelle position X de l'&eacute;toile.
     *
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Retourne la position Y de l'&eacute;toile
     * @return Position de Y de l'&eacute;toile
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Met &agrave; jour la position Y de l'&eacute;toile.
     *
     * @param positionY
     *            La nouvelle position Y de l'&eacute;toile.
     *
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public ArrayList<Satellite> getListeSatellites() {
        return listeSatellites;
    }

    public String toString() {
        return this.nom;
    }

    public void ajouterSatellite(Satellite s) {
        this.listeSatellites.add(s);
    }
}
