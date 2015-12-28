import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by quentin on 24/12/15.
 */
public class ControleurMenu extends Controleur {
    private static final String PATH_RESSOURCES_SOUNDS = "./resources/sounds/";

    public ControleurMenu(Fenetre fenetre, Modele modele){
        super(fenetre, modele);
    }

    public void actionPerformed(ActionEvent e){
        if(fenetre.getItemQuitter() == e.getSource()) {
            System.exit(0);
        }

        else if (fenetre.getItemRestaurer() == e.getSource()) {
            int choix = FenetreDialogue.confirmationRestauration();
            if(choix == JOptionPane.YES_OPTION){
                fenetre.getAudio().stopSound();
                fenetre = new Fenetre(new Modele());
            }
        }

        else if (fenetre.getItemSauvegarder() == e.getSource()) {

        }

        else if (fenetre.getItemSoundOn() == e.getSource()) {
            fenetre.getAudio().stopSound();
            fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS+"star_wars_theme.wav");
        }

        else if (fenetre.getItemSoundOff() == e.getSource()) {
            fenetre.getAudio().stopSound();
        }

        else if (fenetre.getItemNouveauSatellite() == e.getSource()) {
            FenetreDialogue.nouveauSatellite();
        }

        else if (fenetre.getItemNouvelleEtoile() == e.getSource()) {

        }

        else { System.out.println("Are you high bro?"); }
    }
}
