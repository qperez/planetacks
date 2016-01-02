
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;

/**
 * <b>Classe permettant d'afficher les différentes fenêtres de dialogue de l'application.</b>
 */
public class FenetreDialogue {
    private static final String PATH_RESSOURCES_IMG_ASTRES = "./resources/img/astres/";
    private static final String PATH_RESSOURCES_SAVE = "./save/";
    private static final String PATH_RESSOURCES_SOUNDS = "./resources/sounds/";
    private String filename;

    /**
     * M&eacute;thode permettant de cr&eacute;er une boite de dialogue de confirmation de cr&eacute;ation
     * d'un nouveau syst&egrave;me plan&eacute;taire
     * @return l'entier correspondant au type de r&eacute;ponse
     */
    public static int confirmationNouveau() {
        JOptionPane jop = new JOptionPane();
        int reponse = jop.showConfirmDialog(null,
                "Etes-vous sur de vouloir créer un nouveau système planétaire ?",
                "Création d'un nouveau système planétaire",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return reponse;
    }

    /**
     * M&eacute;thode affichant les boites de dialogues n&eacute;cessaires &agrave; l'ajout
     * d'un nouveau Satellite dans l'application
     * @param f la Fenetre de l'application
     */
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
        Dimension dim = new Dimension(200, 400);
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
        final JLabel nomimage = new JLabel("");

        image.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG_ASTRES);
            if (fileChooser.showOpenDialog(null) == 0) {
                String filename = fileChooser.getSelectedFile().getName();
                nomimage.setText(filename);
                ImageIcon image1 = new ImageIcon(new ImageIcon(PATH_RESSOURCES_IMG_ASTRES + filename).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
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
                String ni = nomimage.getText();
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
        int heigthWindow = 650;
        jd.setSize(widthWindow, heigthWindow);
        jd.setLocation(width/2 - widthWindow/2, height/2 - heigthWindow/2);
        jd.setResizable(false);
        jd.setVisible(true);
    }

    /**
     * M&eacute;thode affichant les boites de dialogues n&eacute;cessaires &agrave; l'ajout
     * d'une nouvelle Etoile dans l'application
     * @param f la Fenetre de l'application
     */
    public static void nouvelleEtoile(final Fenetre f) {
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
        final JLabel nomimage = new JLabel("");
        image.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_IMG_ASTRES);
            if (fileChooser.showOpenDialog(null) == 0) {
                String filename = fileChooser.getSelectedFile().getName();
                nomimage.setText(filename);
                ImageIcon image1 = new ImageIcon(new ImageIcon(PATH_RESSOURCES_IMG_ASTRES + filename).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
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
                String ni = nomimage.getText();
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
    }

    public static void sauvegarder(Fenetre fenetre) {
        JOptionPane jop = new JOptionPane();
        String nomFichierXML = jop.showInputDialog(null, "Veuillez entrer le nom du fichier de sauvegarde ", "Sauveagrde du système planétaire", JOptionPane.QUESTION_MESSAGE);
        //----- Debug ----------
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

    /**
     * M&eacute;thode affichant les boites de dialogues n&eacute;cessaires &agrave;
     * la restauration de l'affichage
     * @param fenetre la Fenetre de l'application
     */
    public static void restaurer(Fenetre fenetre) {
        JFileChooser fileChooser = new JFileChooser(PATH_RESSOURCES_SAVE);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == 0) {
            String filename = fileChooser.getSelectedFile().getName();
            String filepath = PATH_RESSOURCES_SAVE + filename;
            try {
                if (filename.equals("starwars.xml")) {
                    fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS + "tir.wav");
                    fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS + "sabre.wav");
                    fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS + "r2d2.wav");
                    fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS + "darkvador.wav");
                    fenetre.getAudio().launchSound(PATH_RESSOURCES_SOUNDS + "star_wars_theme.wav");
                }
                else fenetre.getAudio().stopSound();
                fenetre.getModele().charger(filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * M&eacute;thode affichant les boites de dialogues n&eacute;cessaires
     * au chargement d'un syst&egrave;me plan&eacute;taire
     * @param fenetre la Fenetre de l'application
     */
    public static void ouverture(Fenetre fenetre) {
        JOptionPane jop = new JOptionPane();
        int reponse = jop.showConfirmDialog(null,
                "Voulez vous ouvrir une sauvegarde ?",
                "Ouverture sauvegarde",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (reponse == 0) {
            restaurer(fenetre);
        }
    }

    /**
     * M&eacute;thode affichant les boites de dialogues n&eacute;cessaires &agrave;
     * la suppression d'un astre
     * @param fenetre la Fenetre de l'application
     */
    public static void supprimerAstre(Fenetre fenetre) {
        final JDialog jd = new JDialog();
        jd.setTitle("Supprimer astre");
        jd.setModal(true);

        Box btot = Box.createVerticalBox();
        Box bbouttons = Box.createHorizontalBox();

        JPanel arbre = new JPanel();
        Dimension dim = new Dimension(300, 400);
        arbre.setPreferredSize(dim);
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("Astres existants");
        Iterator<Etoile> it = fenetre.getModele().getListeEtoiles().iterator();
        while (it.hasNext()) {
            Etoile e = it.next();
            a.add(e.getArbreSatellites());
        }
        final JTree arbreAstres = new JTree(a);
        arbreAstres.setPreferredSize(dim);
        arbre.add(arbreAstres);

        JPanel bannuler = new JPanel();
        JPanel bsupprimer = new JPanel();

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(actionEvent -> jd.dispose());

        JButton supprimer = new JButton("Supprimer");
        supprimer.addActionListener(actionEvent -> {
            if (arbreAstres.getLastSelectedPathComponent() == null) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir l'astre à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Astre astre = (Astre) ((DefaultMutableTreeNode) arbreAstres.getLastSelectedPathComponent()).getUserObject();
                astre.supprimer(fenetre.getModele());
                jd.dispose();
            }
        });

        bannuler.add(annuler);
        bsupprimer.add(supprimer);

        bbouttons.add(bannuler);
        bbouttons.add(bsupprimer);

        btot.add(arbre);
        btot.add(bbouttons);
        jd.add(btot);

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        int widthWindow = 350;
        int heigthWindow = 450;
        jd.setSize(widthWindow, heigthWindow);
        jd.setLocation(width/2 - widthWindow/2, height/2 - heigthWindow/2);
        jd.setResizable(false);
        jd.setVisible(true);
    }

    /**
     * M&eacute;thode retournant la chaine de caract&egrave;res correspondant au nom du fichier
     * @return le nom du fichier
     */
    public String getFilename() {
        return filename;
    }

    /**
     * M&eacute;thode mettant &agrave; jour le nom du fichier
     * @param filename le nouveau nom de fichier
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

}
