import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>Classe permettant de mod&eacute;liser un astre.</b>
 * Un Astre est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * <li>Un nom d'image.</li>
 * <li>Une position en X.</li>
 * <li>Une position en Y.</li>
 * <li>Une liste de satellites.</li>
 * </ul>
 */
public class Astre {
    private static final String PATH_RESSOURCES_IMG_ASTRES = "./resources/img/astres/";

    private String nom;
    private String nomImage;
    private int positionX;
    private int positionY;
    private ArrayList<Satellite> listeSatellites;
    private ImageIcon image;

    /**
     * Constructeur Astre.
     * <p>
     * Constructeur vide n&eacute;cessaire &agrave; la sauvegarde XML.
     * </p>
     */
    public Astre(){
        listeSatellites = new ArrayList<Satellite>();
    }

    /**
     * Constructeur Astre.
     * <p>
     * A la construction d'un objet Astre, l'Astre est initinitialis&eacute;
     * avec les param&egrave;tres du constructeur.
     * </p>
     *
     * @param nom Le nom de l'astre
     * @param nomImage Le nom de l'image de l'Astre
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
        this.listeSatellites = new ArrayList<Satellite>();
        this.image = new ImageIcon(PATH_RESSOURCES_IMG_ASTRES + nomImage);
        //this.labelImage = new JLabel();
        this.positionX = positionX - this.image.getIconWidth()/2;
        this.positionY = positionY - this.image.getIconHeight()/2;
    }

    /**
     * Retourne le nom de l'astre
     * @return Nom de l'astre
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met &agrave; jour le nom de l'astre.
     * @param nom Le nouveau nom de l'astre.
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

    /**
     * Met &agrave; jour le nom de l'image de l'Astre
     * @param nomImage Le nouveau nom de l'image de l'Astre.
     */
    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    /**
     * Met &agrave; jour l'ArrayList de Satellite de l'Astre
     * @param listeSatellites La nouvelle ArrayList de Satellite
     */
    public void setListeSatellites(ArrayList<Satellite> listeSatellites) {
        this.listeSatellites = listeSatellites;
    }

    /**
     * Retourne un arbre TreeNode avec les satellites gravitant autour de l'astre
     * @return DefaultMutableTreeNode arbre des satellites de l'Astre
     */
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
     * @param positionX La nouvelle position X de l'&eacute;toile.
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
     * Met &agrave; jour la position Y de l'Astre
     * @param positionY La nouvelle position Y de l'Astre
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Retourne la liste de satellites de l'Astre
     * @return ArrayList de satellites de l'Astre
     */
    public ArrayList<Satellite> getListeSatellites() {
        return listeSatellites;
    }

    /**
     * Retourne le nom de l'astre
     * @return String nom de l'astre
     */
    public String toString() {
        return nom;
    }

    /**
     * Ajoute un satellite à liste des satellites de l'Astre
     * @param s Satellite à ajouter
     */
    public void ajouterSatellite(Satellite s) {
        listeSatellites.add(s);
    }

    /**
     * Méthode permettant de supprimer un Satellite de la liste des satellites
     * @param m Le modele
     */
    public void supprimer(Modele m) {
        Iterator<Satellite> it;
        it = getListeSatellites().iterator();

        if (it.hasNext()) {
            while (it.hasNext()) {
                Satellite s = it.next();
                s.getAstre().listeSatellites.remove(this);
            }
        }

        if (this.getClass() == Etoile.class) m.getListeEtoiles().remove(this);

        else {
            Satellite s = (Satellite) this;
            s.getAstre().listeSatellites.remove(this);
        }
    }

    /**
     * Retourne l'image correspondant à l'Astre
     * @return ImageIcon l'image correspondant à l'Astre
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Met &agrave; jour l'ImageIcon correspondant à l'Astre
     * @param image La nouvelle ImageIcon de l'Astre
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
