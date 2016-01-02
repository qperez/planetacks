/**
 * Created by quentin on 23/12/15.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>Classe permettant cr&eacute;er et g&eacute;rer les donn&eacute;es &agrave; manipuler dans l'application</b>
 * Un Modele est caract&eacute;ris&eacute;e par les informations suivantes :
 * <ul>
 * <li>Une liste d'&eacute;toiles</li>
 * </ul>
 */

public class Modele {
    private ArrayList<Etoile> listeEtoiles;

    /**
     * Constructeur de Modele
     * Instancie une nouvelle ArrayList d'Etoile
     */
    public Modele(){
        this.listeEtoiles = new ArrayList<Etoile>();
    }

    /**
     * Constructeur de Modele
     * @param listeEtoiles ArrayList d'Etoile
     */
    public Modele(ArrayList<Etoile> listeEtoiles) {
        this.listeEtoiles = listeEtoiles;
    }

    /**
     * M&eacute;thode permettant d'ajouter une Etoile &agrave; la liste des Etoiles du Modele
     * @param e Etoile &agrave; ajouter
     */
    public void ajouterEtoile(Etoile e) {
        this.listeEtoiles.add(e);
    }

    /**
     * M&eacute;thode retournant un Astre suivant son nom
     * @param nom de l'Etoile
     * @return astre correspondant au nom
     */
    public Astre getAstre(String nom) {
        Iterator<Etoile> it = this.listeEtoiles.iterator();
        while (it.hasNext()) {
            Astre a = it.next();
            if (a.getNom() == nom) return a;
        }
        return null;
    }

    /**
     * M&eacute;thode retournant la liste d'Etoile du modele
     * @return ArrayList d'Etoile
     */
    public ArrayList<Etoile> getListeEtoiles() {
        return this.listeEtoiles;
    }

    /**
     * M&eacute;thode permettant de sauvegarder le syst&egrave;me plan&eacute;taire dans un fichier XML
     * @param nomFichierXML &agrave; sauvegarde
     * @throws IOException Exception I/O du fichier demand&eacute;
     */
    public void sauvegarder(String nomFichierXML) throws IOException {
        XMLTools.encodeToFile(listeEtoiles, nomFichierXML);
    }

    /**
     * M&eacute;thode permettant de charger un syst&egrave;me plan&eacute;taire au format XML
     * @param nomFichierXML &agrave; charger
     * @throws IOException Exception I/O du fichier demand&eacute;
     */
    public void charger(String nomFichierXML) throws IOException {
        this.listeEtoiles = (ArrayList<Etoile>)XMLTools.decodeFromFile(nomFichierXML);
    }
}