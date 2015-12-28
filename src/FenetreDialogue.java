import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by quentin on 27/12/15.
 */
public class FenetreDialogue {
    private static final String PATH_RESSOURCES_IMG = "./resources/img/";

    public static int confirmationRestauration(){
        JOptionPane jop = new JOptionPane();
        int reponse = jop.showConfirmDialog(null,
                "Etes-vous sur de vouloir créer un nouveau système planétaire ?",
                "Création d'un nouveau système planétaire",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return reponse;
    }

    public static void nouveauSatellite() {
        JDialog jd = new JDialog();
        jd.setTitle("Nouveu satellite");
        jd.setModal(true);

        Box btot = Box.createVerticalBox();
        Box binfos = Box.createHorizontalBox();
        Box label = Box.createVerticalBox();
        Box text = Box.createVerticalBox();

        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        text.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        left.add(new JLabel("Entrez le nom du satellite : "));
        right.add(new JTextField(15));
        label.add(left);
        text.add(right);

        left = new JPanel();
        right = new JPanel();
        left.add(new JLabel("Entrez le demi grand axe X : "));
        right.add(new JTextField(5));
        label.add(left);
        text.add(right);

        left = new JPanel();
        right = new JPanel();
        left.add(new JLabel("Entrez le demi grand axe Y : "));
        right.add(new JTextField(5));
        label.add(left);
        text.add(right);

        left = new JPanel();
        right = new JPanel();
        left.add(new JLabel("Entrez la période de révolution : "));
        right.add(new JTextField(5));
        label.add(left);
        text.add(right);

        binfos.add(label);
        binfos.add(text);

        JPanel buttonImage = new JPanel();
        JButton image = new JButton("Image satellite");
        JLabel apercu = new JLabel("");
        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG);
                if (fileChooser.showOpenDialog(null) == 0) {
                    String filename = PATH_RESSOURCES_IMG+fileChooser.getSelectedFile().getName();
                    System.out.println(filename);
                     apercu.setIcon(new ImageIcon(filename));
                    ((Component) e.getSource()).getParent().repaint();
                }
            }
        });
        buttonImage.add(apercu);
        buttonImage.add(image);

        JPanel validate = new JPanel();

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jd.dispose();
            }
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        validate.add(annuler);
        validate.add(valider);

        btot.add(binfos);
        btot.add(buttonImage);
        btot.add(validate);

        jd.add(btot);
        jd.setSize(400,400);
        jd.setLocation(400, 200);
        jd.pack();
        jd.setResizable(false);
        jd.setVisible(true);
    }
}
