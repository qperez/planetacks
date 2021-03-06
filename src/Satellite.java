/**
 * <b>Classe permettant de mod&eacute;liser un satellite.</b>
 * Un Satellite est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * <li>Un nom d'image.</li>
 * <li>Un demi-grand axe.</li>
 * <li>Un demi-petit axe.</li>
 * <li>Une p&eacute;riode</li>
 * <li>Un astre autour duquel gravite le satellite</li>
 * </ul>
 */
public class Satellite extends Astre{

    private int demiGrandAxe;
    private int demiPetitAxe;
    private int periode;
    private Astre astre;

    /**
     * Constructeur Astre.
     * <p>
     * Constructeur vide n&eacute;cessaire &agrave; la sauvegarde XML.
     * </p>
     */
    public Satellite(){
        super();
    }

    /**
     * Constructeur Satellite.
     * <p>
     * A la construction d'un objet Astre, le Satellite est initinitialis&eacute;
     * avec les param&egrave;tres du constructeur.
     * </p>
     *
     * @param nom       Le nom du satellite
     * @param nomImage  Le nom de l'image du satellite
     * @param demiGrandAxe Taille du demi-grand axe
     * @param demiPetitAxe Taille du demi-petit axe
     * @param periode de r&eacute;volution de l'astre
     * @param astre autour duquel gravite le satellite
     *
     * @see Astre#nom
     * @see Satellite#demiGrandAxe
     * @see Satellite#demiPetitAxe
     * @see Satellite#periode
     * @see Satellite#astre
     */
    public Satellite(String nom, String nomImage,
                     int demiGrandAxe, int demiPetitAxe,
                     int periode, Astre astre) {
        super(nom, nomImage, astre.getPositionX(), astre.getPositionY());
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
        this.periode = periode;
        this.astre = astre;
        this.astre.ajouterSatellite(this);
    }

    /**
     * Retourne la taille du demi petit axe du satellite
     * @return Taille du demi-petit axe
     */
    public int getDemiPetitAxe() {
        return demiPetitAxe;
    }

    /**
     * Met &agrave; jour le demi petit axe du satellite.
     * @param demiPetitAxe La nouvelle taille du demi petit axe du satellite.
     */
    public void setDemiPetitAxe(int demiPetitAxe) {
        this.demiPetitAxe = demiPetitAxe;
    }

    /**
     * Retourne la taille du demi grand axe du satellite
     * @return Taille du demi-grand axe
     */
    public int getDemiGrandAxe() {
        return demiGrandAxe;
    }

    /**
     * Met &agrave; jour le demi grand axe du satellite.
     * @param demiGrandAxe La nouvelle taille du demi grand axe du satellite.
     */
    public void setDemiGrandAxe(int demiGrandAxe) {
        this.demiGrandAxe = demiGrandAxe;
    }

    /**
     * Retourne la p&eacute;riode du satellite
     * @return P&eacute;riode du satellite
     */
    public int getPeriode() {
        return periode;
    }

    /**
     * Met &agrave; jour la p&eacute;riode du satellite.
     * @param periode La nouvelle p&eacute;riode du satellite.
     */
    public void setPeriode(int periode) {
        this.periode = periode;
    }

    /**
     * Retourne l'astre autour duquel gravite le satellite
     * @return Astre de gravitation
     */
    public Astre getAstre() {
        return astre;
    }

    /**
     * Met &agrave; jour l'astre autour duquel gravite le satellite.
     * @param astre Le nouvelle astre de gravitation satellite.
     */
    public void setAstre(Astre astre) {
        this.astre = astre;
    }

    /**
     * Retourne le nomp du Satellite
     * @return String le nom du Satellite
     */
    public String toString() {
        return getNom();
    }

    /**
     * Calcul la position du Satellite en X en fonction du temps t
     * @param t le temps
     * @return int la nouvelle position X
     */
    public int calculPositionSatelliteX(float t) {
        int x = (int) (demiGrandAxe * Math.cos(t/periode) + astre.getPositionX() + (astre.getImage().getIconWidth() - this.getImage().getIconWidth())/2);
        setPositionX(x);
        return x;
    }

    /**
     * Calcul la position du Satellite en Y en fonction du temps t
     * @param t le temps
     * @return int la nouvelle position Y
     */
    public int calculPositionSatelliteY(float t) {
        int y = (int) (demiPetitAxe * Math.sin(t/periode) + astre.getPositionY() + (astre.getImage().getIconHeight() - this.getImage().getIconHeight())/2);
        setPositionY(y);
        return y;
    }

}
