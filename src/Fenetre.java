import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by quentin on 23/12/15.
 */

/**
 * <b>Classe permettant créer et gérer l'affichage</b>
 * Une Fenetre est caractérisée par les informations suivantes :
 * <ul>
 * <li>Un Modele.</li>
 * <li>Des JMenuItem.</li>
 * <li>Des controleurs .</li>
 * <li>Des JLabels</li>
 * </ul>
 */
public class Fenetre extends JFrame {

    //Constante permettant de parametrer le chemin relatif aux ressources images nécessaires
    private static final String PATH_RESSOURCES_IMG_APPLI = "./resources/img/appli/";
    private static final String PATH_RESSOURCES_SOUNDS = "./resources/sounds/";


    private Modele modele;
    private JPanel jpaneGlobal;

    private JMenuItem itemQuitter;
    private JMenuItem itemNouveau;
    private JMenuItem itemSauvegarder;
    private JMenuItem itemRestaurer;

    private JMenuItem itemNouvelleEtoile;
    private JMenuItem itemNouveauSatellite;
    private JMenuItem itemSupprimerAstre;

    private JMenuItem itemSonOn;
    private JMenuItem itemSonOff;

    private ControleurMenu controleurMenu;

    private Audio audio;

    /**
     * Constructeur Fenetre.
     * <p>
     * A la construction d'un objet Fenetre, la Fenetre est initinitialis&eacute;e
     * avec commme param&egrave;tres un Modele.
     * </p>
     *
     * @param modele le modele servant à la construction
     * @see Fenetre#modele
     */
    public Fenetre(Modele modele) {
        this.modele = modele;
        setIconImage(new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "icone_appli.jpg").getImage()); //Affiche une icone d'application
        initAttributs();
        creerVue();
        creerMenu();

        //audio.launchSound(PATH_RESSOURCES_SOUNDS+"star_wars_theme.wav");
    }

    /**
     * Fonction permettant d'initialiser les éléments graphiques Java Swing,
     * ainsi que l'ajout des Actions Listener sur les éléments
     */
    private void initAttributs() {
        itemQuitter = new JMenuItem("Quitter", new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "exit.png"));
        itemNouveau = new JMenuItem("Nouveau système planétaire");
        itemSauvegarder = new JMenuItem("Sauvegarder le système planétaire");
        itemRestaurer = new JMenuItem("Restaurer un système enregistré");

        itemNouvelleEtoile = new JMenuItem("Nouvelle étoile");
        itemNouveauSatellite = new JMenuItem("Nouveau satellite");
        itemSupprimerAstre = new JMenuItem("Supprimer astre");

        itemSonOn = new JMenuItem("Activer le son", new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "sonOn.png"));
        itemSonOff = new JMenuItem("Couper le son", new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "sonOff.png"));

        audio = new Audio();
    }

    /**
     * Fonction permettant de créer la barre de menu (JMenuBar)
     *
     * @return la barre de menu JMenuBar
     */
    private JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuOptions = new JMenu("Outils");
        JMenu menuSon = new JMenu("Son");

        menuFichier.add(itemNouveau);
        menuFichier.add(itemSauvegarder);
        menuFichier.add(itemRestaurer);
        menuFichier.add(itemQuitter);

        menuOptions.add(itemNouvelleEtoile);
        menuOptions.add(itemNouveauSatellite);
        menuOptions.add(itemSupprimerAstre);

        menuSon.add(itemSonOn);
        menuSon.add(itemSonOff);

        menuBar.add(menuFichier);
        menuBar.add(menuOptions);
        menuBar.add(menuSon);

        setJMenuBar(menuBar);

        //Création du controleur du menu et ajout des actions listener sur les items
        controleurMenu = new ControleurMenu(this, modele);
        itemNouveau.addActionListener(controleurMenu);
        itemSauvegarder.addActionListener(controleurMenu);
        itemRestaurer.addActionListener(controleurMenu);
        itemQuitter.addActionListener(controleurMenu);

        itemNouveauSatellite.addActionListener(controleurMenu);
        itemNouvelleEtoile.addActionListener(controleurMenu);
        itemSupprimerAstre.addActionListener(controleurMenu);

        itemSonOn.addActionListener(controleurMenu);
        itemSonOff.addActionListener(controleurMenu);

        return menuBar;
    }

    /**
     * Fonction permettant d'ajouter les différents éléments graphiques à la JFrame
     */
    private void creerVue() {
        setSize(1024, 768); //Fixe la taille par défaut
        setTitle("Planethacks : système planétaire");setVisible(true); //Affiche la fenêtre
        setResizable(false); //Permet de ne pas resizer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Gère la fermeture
        jpaneGlobal = new JPanel();
        try {
            jpaneGlobal = new JPanel() {
                private static final long serialVersionUID = 1;

                private BufferedImage buf = ImageIO.read(new File(PATH_RESSOURCES_IMG_APPLI + "background.jpg"));

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(buf, 0, 0, null);
                }
            };

            jpaneGlobal.setLayout(null);
            setContentPane(jpaneGlobal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*ImageIcon lune = new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "../astres/lune.png");
        JLabel a = new JLabel(lune);
        a.setBounds(100, 100, lune.getIconWidth(), lune.getIconHeight());
        jpaneGlobal.add(a);*/
    }


    public Modele getModele() {
        return modele;
    }

    public Audio getAudio() {
        return audio;
    }

    /**
     * Retourne le JMenuItem permettant de quitter l'application
     *
     * @return Item quitter
     */
    public JMenuItem getItemQuitter() {
        return itemQuitter;
    }

    /**
     * Retourne le JMenuItem permettant de restaurer le système planétaire
     *
     * @return Item restaurer
     */
    public JMenuItem getItemNouveau() {
        return itemNouveau;
    }

    /**
     * Retourne le JMenuItem permettant de sauvegarder
     *
     * @return Item sauvegarder
     */
    public JMenuItem getItemSauvegarder() {
        return itemSauvegarder;
    }

    /**
     * Retourne le JMenuItem permettant de restaurer
     *
     * @return Item restaurer
     */
    public JMenuItem getItemRestaurer() {
        return itemRestaurer;
    }

    public JMenuItem getItemSoundOn() {
        return itemSonOn;
    }

    public JMenuItem getItemSoundOff() {
        return itemSonOff;
    }

    public JMenuItem getItemNouvelleEtoile() {
        return itemNouvelleEtoile;
    }

    public JMenuItem getItemNouveauSatellite() {
        return itemNouveauSatellite;
    }

    public JMenuItem getItemSupprimerAstre() {
        return itemSupprimerAstre;
    }

    public JPanel getJpaneGlobal() {
        return jpaneGlobal;
    }
}
