import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * <b>Classe permettant de cr&eacute;er un contr&ocirc;leur de Menu</b>
 */
public class ControleurMenu extends Controleur {
    private static final String PATH_RESSOURCES_SOUNDS = "./resources/sounds/";

    /**
     * Constructeur de ControleurMenu
     * @param fenetre la Fenetre de l'application
     * @param modele le Modele de l'application
     *
     * @see Controleur#Controleur(Fenetre, Modele)
     */
    public ControleurMenu(Fenetre fenetre, Modele modele){
        super(fenetre, modele);
    }

    /**
     * Impl&eacute;mentation de la m&eacute;thode actionPerformed
     * @param e l'ActionEvent en provenance du listener
     */
    public void actionPerformed(ActionEvent e){
        if(fenetre.getItemQuitter() == e.getSource()) {
            System.exit(0);
        }

        else if (fenetre.getItemNouveau() == e.getSource()) {
            int choix = FenetreDialogue.confirmationNouveau();
            if(choix == JOptionPane.YES_OPTION){
                fenetre.getAudio().stopSound();
                fenetre = new Fenetre(new Modele());
            }
        }

        else if (fenetre.getItemSauvegarder() == e.getSource()) {
            FenetreDialogue.sauvegarder(fenetre);
        }

        else if (fenetre.getItemRestaurer() == e.getSource()) {
            FenetreDialogue.restaurer(fenetre);
        }

        else if (fenetre.getItemSoundOn() == e.getSource()) {
            fenetre.getAudio().stopSound();
            fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS+"star_wars_theme.wav");
        }

        else if (fenetre.getItemSoundOff() == e.getSource()) {
            fenetre.getAudio().stopSound();
        }

        else if (fenetre.getItemNouveauSatellite() == e.getSource()) {
            FenetreDialogue.nouveauSatellite(fenetre);
        }

        else if (fenetre.getItemNouvelleEtoile() == e.getSource()) {
            FenetreDialogue.nouvelleEtoile(fenetre);
        }

        else if (fenetre.getItemSupprimerAstre() == e.getSource()) {
            FenetreDialogue.supprimerAstre(fenetre);
        }
    }
}
