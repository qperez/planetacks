/**
 * <b>Classe permettant de mod&eacute;liser un astre.</b>
 * Un Astre est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * </ul>
 */
public class Astre {

    private String nom;
    private int positionX;
    private int positionY;

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
    public Astre(String nom, int positionX, int positionY){
        this.nom = nom;
        this.positionX = positionX;
        this.positionY = positionY;
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
}
