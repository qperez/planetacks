
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Created by quentin on 27/12/15.
 */
public class FenetreDialogue {
    private static final String PATH_RESSOURCES_IMG = "./resources/img/";

    public static int confirmationRestauration() {
        JOptionPane jop = new JOptionPane();
        int reponse = jop.showConfirmDialog(null,
                "Etes-vous sur de vouloir créer un nouveau système planétaire ?",
                "Création d'un nouveau système planétaire",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return reponse;
    }

    public static void nouveauSatellite(Fenetre f) {
        final JDialog jd = new JDialog();
        jd.setTitle("Nouveau satellite");
        jd.setModal(true);

        Box btot = Box.createVerticalBox();
        Box binfos = Box.createHorizontalBox();
        Box label = Box.createVerticalBox();
        Box text = Box.createVerticalBox();

        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        text.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel leftNom = new JPanel();
        JPanel rightNom = new JPanel();
        leftNom.add(new JLabel("Entrez le nom du satellite : "));
        JTextField nomSatellite = new JTextField(15);
        rightNom.add(nomSatellite);
        label.add(leftNom);
        text.add(rightNom);

        JPanel leftArbre = new JPanel();
        JPanel rightArbre = new JPanel();
        Dimension dim = new Dimension(200, 200);
        leftArbre.setPreferredSize(dim);
        leftArbre.add(new JLabel("Choisissez l'astre référent : "));
        // Création d'une fonction récursive si un satellite a un satellite etc
        DefaultMutableTreeNode arbre = new DefaultMutableTreeNode("Astres existants");
        Iterator<Etoile> it = f.getModele().getListeEtoiles().iterator();
        while (it.hasNext()) {
            Etoile e = it.next();
            arbre.add(e.getArbreSatellites());
        }
        JTree arbreAstres = new JTree(arbre);
        arbreAstres.setPreferredSize(dim);
        rightArbre.add(arbreAstres);
        label.add(leftArbre);
        text.add(rightArbre);

        JPanel leftDemiX = new JPanel();
        JPanel rightDemiX = new JPanel();
        leftDemiX.add(new JLabel("Entrez le demi grand axe X : "));
        JTextField demiX = new JTextField(5);
        rightDemiX.add(demiX);
        label.add(leftDemiX);
        text.add(rightDemiX);

        JPanel leftDemiY = new JPanel();
        JPanel rightDemiY = new JPanel();
        leftDemiY.add(new JLabel("Entrez le demi grand axe Y : "));
        JTextField demiY = new JTextField(5);
        rightDemiY.add(demiY);
        label.add(leftDemiY);
        text.add(rightDemiY);

        JPanel leftPeriode = new JPanel();
        JPanel rightPeriode = new JPanel();
        leftPeriode.add(new JLabel("Entrez la période de révolution : "));
        JTextField periodeRevolution = new JTextField(5);
        rightPeriode.add(periodeRevolution);
        label.add(leftPeriode);
        text.add(rightPeriode);

        binfos.add(label);
        binfos.add(text);

        JPanel buttonImage = new JPanel();
        JButton image = new JButton("Image satellite");
        final JLabel apercu = new JLabel("");

        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG);
                if (fileChooser.showOpenDialog(null) == 0) {
                    String filename = PATH_RESSOURCES_IMG + fileChooser.getSelectedFile().getName();
                    ImageIcon image = new ImageIcon(filename);
                    apercu.setIcon(image);
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
                String ns = nomSatellite.getText();
                String ni = apercu.getIcon().toString();
                int dX = Integer.parseInt(demiX.getText());
                int dY = Integer.parseInt(demiY.getText());
                int pr = Integer.parseInt(periodeRevolution.getText());
                Astre a = (Astre)arbreAstres.getLastSelectedPathComponent();
                System.out.println(ni);
            }
        });

        validate.add(annuler);
        validate.add(valider);

        btot.add(binfos);
        btot.add(buttonImage);
        btot.add(validate);

        jd.add(btot);
        jd.setLocation(400, 200);
        jd.pack();
        jd.setResizable(false);
        jd.setVisible(true);
    }

    public static Etoile nouvelleEtoile() {
        final JDialog jd = new JDialog();
        jd.setTitle("Nouveau satellite");
        jd.setModal(true);

        Box btot = Box.createVerticalBox();
        Box binfos = Box.createHorizontalBox();
        Box label = Box.createVerticalBox();
        Box text = Box.createVerticalBox();

        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        text.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        left.add(new JLabel("Entrez le nom de l'étoile : "));
        right.add(new JTextField(15));
        label.add(left);
        text.add(right);

        left = new JPanel();
        right = new JPanel();
        left.add(new JLabel("Entrez la position X : "));
        right.add(new JTextField(5));
        label.add(left);
        text.add(right);

        left = new JPanel();
        right = new JPanel();
        left.add(new JLabel("Entrez la position Y : "));
        right.add(new JTextField(5));
        label.add(left);
        text.add(right);

        binfos.add(label);
        binfos.add(text);

        JPanel buttonImage = new JPanel();
        JButton image = new JButton("Image satellite");
        final JLabel apercu = new JLabel("");
        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG);
                if (fileChooser.showOpenDialog(null) == 0) {
                    String filename = PATH_RESSOURCES_IMG + fileChooser.getSelectedFile().getName();
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
        jd.setLocation(400, 200);
        jd.pack();
        jd.setResizable(false);
        jd.setVisible(true);

        return null;
    }
}
