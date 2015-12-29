
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by quentin on 27/12/15.
 */
public class FenetreDialogue {
    private static final String PATH_RESSOURCES_IMG_ASTRES = "./resources/img/astres/";
    private static final String PATH_RESSOURCES_SAVE = "./save/";

    public static int confirmationNouveau() {
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
        final JTextField nomSatellite = new JTextField(15);
        rightNom.add(nomSatellite);
        label.add(leftNom);
        text.add(rightNom);

        JPanel leftArbre = new JPanel();
        JPanel rightArbre = new JPanel();
        Dimension dim = new Dimension(180, 200);
        leftArbre.setPreferredSize(dim);
        leftArbre.add(new JLabel("Choisissez l'astre référent : "));
        // Création d'une fonction récursive si un satellite a un satellite etc
        DefaultMutableTreeNode arbre = new DefaultMutableTreeNode("Astres existants");
        Iterator<Etoile> it = f.getModele().getListeEtoiles().iterator();
        while (it.hasNext()) {
            Etoile e = it.next();
            arbre.add(e.getArbreSatellites());
        }
        final JTree arbreAstres = new JTree(arbre);
        arbreAstres.setPreferredSize(dim);
        rightArbre.add(arbreAstres);
        label.add(leftArbre);
        text.add(rightArbre);

        JPanel leftDemiX = new JPanel();
        JPanel rightDemiX = new JPanel();
        leftDemiX.add(new JLabel("Entrez le demi grand axe X : "));
        final JTextField demiX = new JTextField(5);
        rightDemiX.add(demiX);
        label.add(leftDemiX);
        text.add(rightDemiX);

        JPanel leftDemiY = new JPanel();
        JPanel rightDemiY = new JPanel();
        leftDemiY.add(new JLabel("Entrez le demi grand axe Y : "));
        final JTextField demiY = new JTextField(5);
        rightDemiY.add(demiY);
        label.add(leftDemiY);
        text.add(rightDemiY);

        JPanel leftPeriode = new JPanel();
        JPanel rightPeriode = new JPanel();
        leftPeriode.add(new JLabel("Entrez la période de révolution : "));
        final JTextField periodeRevolution = new JTextField(5);
        rightPeriode.add(periodeRevolution);
        label.add(leftPeriode);
        text.add(rightPeriode);

        binfos.add(label);
        binfos.add(text);

        JPanel buttonImage = new JPanel();
        JButton image = new JButton("Image satellite");
        final JLabel apercu = new JLabel("");

        image.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG_ASTRES);
            if (fileChooser.showOpenDialog(null) == 0) {
                String filename = PATH_RESSOURCES_IMG_ASTRES + fileChooser.getSelectedFile().getName();
                ImageIcon image1 = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                apercu.setIcon(image1);
                ((Component) e.getSource()).getParent().repaint();
            }
        });
        buttonImage.add(apercu);
        buttonImage.add(image);

        JPanel validate = new JPanel();

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(actionEvent -> jd.dispose());

        JButton valider = new JButton("Valider");
        valider.addActionListener(actionEvent -> {
            if (nomSatellite.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer le nom du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (apercu.getIcon() == null) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir l'image du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (demiX.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer le demi grand axe X du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (demiY.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer le demi grand axe Y du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (periodeRevolution.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer la période du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!demiX.getText().matches("[-+]?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(null, "Le demi grand axe X du satellite doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!demiY.getText().matches("[-+]?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(null, "Le demi grand axe X du satellite doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!periodeRevolution.getText().matches("[-+]?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(null, "La période du satellite doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (arbreAstres.getLastSelectedPathComponent() == null) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir l'astre référent du satellite", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                String ns = nomSatellite.getText();
                String ni = apercu.getIcon().toString();
                int dX = Integer.parseInt(demiX.getText());
                int dY = Integer.parseInt(demiY.getText());
                int pr = Integer.parseInt(periodeRevolution.getText());
                Astre a = (Astre) ((DefaultMutableTreeNode) arbreAstres.getLastSelectedPathComponent()).getUserObject();
                Satellite s = new Satellite(ns, ni, dX, dY, pr, a);
                jd.dispose();
            }
        });

        validate.add(annuler);
        validate.add(valider);

        btot.add(binfos);
        btot.add(buttonImage);
        btot.add(validate);

        jd.add(btot);
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        int widthWindow = 500;
        int heigthWindow = 450;
        jd.setSize(widthWindow, heigthWindow);
        jd.setLocation(width/2 - widthWindow/2, height/2 - heigthWindow/2);
        jd.setResizable(false);
        jd.setVisible(true);
    }

    public static Etoile nouvelleEtoile(final Fenetre f) {
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
        leftNom.add(new JLabel("Entrez le nom de l'étoile : "));
        final JTextField nomEtoile = new JTextField(15);
        rightNom.add(nomEtoile);
        label.add(leftNom);
        text.add(rightNom);

        JPanel leftPosX = new JPanel();
        JPanel rightPosX = new JPanel();
        leftPosX.add(new JLabel("Entrez la position X : "));
        final JTextField posXEtoile = new JTextField(5);
        rightPosX.add(posXEtoile);
        label.add(leftPosX);
        text.add(rightPosX);

        JPanel leftPosY = new JPanel();
        JPanel rightPosY = new JPanel();
        leftPosY.add(new JLabel("Entrez la position Y : "));
        final JTextField posYEtoile = new JTextField(5);
        rightPosY.add(posYEtoile);
        label.add(leftPosY);
        text.add(rightPosY);

        binfos.add(label);
        binfos.add(text);

        JPanel buttonImage = new JPanel();
        JButton image = new JButton("Image étoile");
        final JLabel apercu = new JLabel("");
        image.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG_ASTRES);
            if (fileChooser.showOpenDialog(null) == 0) {
                String filename = PATH_RESSOURCES_IMG_ASTRES + fileChooser.getSelectedFile().getName();
                ImageIcon image1 = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                apercu.setIcon(image1);
                ((Component) e.getSource()).getParent().repaint();
            }
        });
        buttonImage.add(apercu);
        buttonImage.add(image);

        JPanel validate = new JPanel();

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(actionEvent -> jd.dispose());

        JButton valider = new JButton("Valider");
        valider.addActionListener(actionEvent -> {
            if (nomEtoile.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer le nom de l'étoile", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (apercu.getIcon() == null) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir l'image de l'étoile", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (posXEtoile.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer la position X de l'étoile", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (posYEtoile.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer la position Y de l'étoile", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!posXEtoile.getText().matches("[-+]?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(null, "La position X de l'étoile doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!posYEtoile.getText().matches("[-+]?\\d*\\.?\\d+")) {
                JOptionPane.showMessageDialog(null, "La position Y de l'étoile doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                String ne = nomEtoile.getText();
                String ni = apercu.getIcon().toString();
                int dX = Integer.parseInt(posXEtoile.getText());
                int dY = Integer.parseInt(posYEtoile.getText());
                Etoile e = new Etoile(ne, ni, dX, dY);
                f.getModele().ajouterEtoile(e);
                jd.dispose();
            }
        });

        validate.add(annuler);
        validate.add(valider);

        btot.add(binfos);
        btot.add(buttonImage);
        btot.add(validate);

        jd.add(btot);
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        int widthWindow = 400;
        int heigthWindow = 200;
        jd.setSize(widthWindow, heigthWindow);
        jd.setLocation(width/2 - widthWindow/2, height/2 - heigthWindow/2);
        jd.setResizable(false);
        jd.setVisible(true);

        return null;
    }

    public static void sauvegarder(Fenetre fenetre) {
        JOptionPane jop = new JOptionPane();
        String nomFichierXML = jop.showInputDialog(null, "Veuillez entrer le nom du fichier de sauvegarde ", "Sauveagrde du système planétaire", JOptionPane.QUESTION_MESSAGE);
        //----- Debug ----------
        System.out.println(nomFichierXML);
        while (nomFichierXML.equals("")) {
            JOptionPane jopErreurStringVide = new JOptionPane();
            jopErreurStringVide.showMessageDialog(null, "Veuillez entrer un nom de fichier");
            nomFichierXML = jop.showInputDialog(null, "Veuillez entrer le nom du fichier de sauvegarde ", "Sauveagrde du système planétaire", JOptionPane.QUESTION_MESSAGE);
        }

        try {
            fenetre.getModele().sauvegarder(PATH_RESSOURCES_SAVE + nomFichierXML + ".xml");
        } catch (IOException e) {
            JOptionPane jopException = new JOptionPane();
            jopException.showMessageDialog(null, e.toString());
            e.printStackTrace();
        }
    }

    public static void restaurer(Fenetre fenetre) {
        JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_SAVE);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == 0) {
            String filename = PATH_RESSOURCES_SAVE + fileChooser.getSelectedFile().getName();
            try {
                fenetre.getModele().charger(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
