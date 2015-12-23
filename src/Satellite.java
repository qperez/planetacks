/**
 * <b>Classe permettant de mod&eacute;liser un satellite.</b>
 * Un Satellite est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un nom.</li>
 * <li>Un demi-grand axe.</li>
 * <li>Un demi-petit axe.</li>
 * <li>Une période</li>
 * <li>Un astre autour duquel gravite le satellite</li>
 * </ul>
 */
public class Satellite extends Astre{

    private int demiGrandAxe;
    private int demiPetitAxe;
    private int periode;
    private Astre astre;

    /**
     * Constructeur Satellite.
     * <p>
     * A la construction d'un objet Astre, le Satellite est initinitialisé
     * avec les paramètres du constructeur.
     * </p>
     *
     * @param nom       Le nom du satellite
     * @param demiGrandAxe Taille du demi-grand axe
     * @param demiPetitAxe Taille du demi-petit axe
     * @param periode periode de révolution de l'astre
     * @param astre Astre autour duquel gravite le satellite
     *
     * @see Astre#nom
     * @see Satellite#demiGrandAxe
     * @see Satellite#demiPetitAxe
     * @see Satellite#periode
     * @see Satellite#astre
     */
    public Satellite(String nom,
                     int demiGrandAxe, int demiPetitAxe,
                     int periode, Astre astre) {
        super(nom, astre.getPositionX(), astre.getPositionY());
        this.demiGrandAxe = demiGrandAxe;
        this.demiPetitAxe = demiPetitAxe;
        this.periode = periode;
        this.astre = astre;
    }

    /**
     * Retourne la taille du demi petit axe du satellite
     * @return Taille du demi-petit axe
     */
    public int getDemiPetitAxe() {
        return demiPetitAxe;
    }

    /**
     * Met à jour le demi petit axe du satellite.
     *
     * @param demiPetitAxe
     *            La nouvelle taille du demi petit axe du satellite.
     *
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
     * Met à jour le demi grand axe du satellite.
     *
     * @param demiGrandAxe
     *            La nouvelle taille du demi grand axe du satellite.
     *
     */
    public void setDemiGrandAxe(int demiGrandAxe) {
        this.demiGrandAxe = demiGrandAxe;
    }

    /**
     * Retourne la période du satellite
     * @return P&eacute;riode du satellite
     */
    public int getPeriode() {
        return periode;
    }

    /**
     * Met &agrave; jour la p&eacute;riode du satellite.
     *
     * @param periode
     *            La nouvelle p&eacute;riode du satellite.
     *
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
     *
     * @param astre
     *            Le nouvelle astre de gravitation satellite.
     *
     */
    public void setAstre(Astre astre) {
        this.astre = astre;
    }

    public int calculPositionSatelliteX(int t) {
        /*x=a.cos(t/p)+xAstreRéférent
          y=b.sin(t/p)+yAstreRéférent*/
        int x = (int) (demiGrandAxe * Math.cos(t/periode) * astre.getPositionX());
        setPositionX(x);
        return x;
    }

    public int calculPositionSatelliteY(int t) {
        /*x=a.cos(t/p)+xAstreRéférent
          y=b.sin(t/p)+yAstreRéférent*/
        int y = (int) (demiGrandAxe * Math.cos(t/periode) * astre.getPositionY());
        setPositionY(y);
        return y;
    }

}
