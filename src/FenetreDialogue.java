import javax.swing.*;
import javax.swing.JOptionPane;

/**
 * Created by quentin on 27/12/15.
 */
public class FenetreDialogue {

    public static int confirmationRestauration(){
        JOptionPane jop = new JOptionPane();
        int reponse = jop.showConfirmDialog(null,
                "Etes-vous sur de vouloir créer un nouveau système planétaire ?",
                "Création d'un nouveau système planétaire",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return reponse;
    }

}
