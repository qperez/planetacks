/**
 * Created by quentin on 23/12/15.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>Classe permettant créer et gérer les données à manipuler dans l'application</b>
 * Un Modele est caractérisée par les informations suivantes :
 * <ul>
 * <li>.</li>
 * </ul>
 */

public class Modele {
    private ArrayList<Etoile> listeEtoiles = new ArrayList<Etoile>();

    public Modele(){
        this.listeEtoiles = new ArrayList<>();
    }

    public Modele(ArrayList<Etoile> listeEtoiles) {
        this.listeEtoiles = listeEtoiles;
    }

    public void ajouterEtoile(Etoile e) {
        this.listeEtoiles.add(e);
    }

    public Astre getAstre(String nom) {
        Iterator<Etoile> it = this.listeEtoiles.iterator();
        while (it.hasNext()) {
            Astre a = it.next();
            if (a.getNom() == nom) return a;
        }
        return null;
    }

    public ArrayList<Etoile> getListeEtoiles() {
        return this.listeEtoiles;
    }
}