import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by quentin on 23/12/15.
 */

/**
 * <b>Classe permettant cr&eacute;er et g&eacute;rer l'affichage</b>
 * Une Fenetre est caract&eacute;ris&eacute;e par les informations suivantes :
 * <ul>
 * <li>Un Modele.</li>
 * <li>Des JMenuItem.</li>
 * <li>Un controleurMenu .</li>
 * <li>Un Audio</li>
 * <li>Un AffichageAstres</li>
 * </ul>
 */
public class Fenetre extends JFrame {

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

    private AffichageAstres affichageAstres;

    /**
     * Constructeur Fenetre.
     * <p>
     * A la construction d'un objet Fenetre, la Fenetre est initinitialis&eacute;e
     * avec commme param&egrave;tres un Modele.
     * </p>
     *
     * @param modele le Modele servant à la construction
     * @see Fenetre#modele
     */
    public Fenetre(Modele modele) {
        this.modele = modele;
        setIconImage(new ImageIcon(PATH_RESSOURCES_IMG_APPLI + "icone_appli.jpg").getImage()); //Affiche une icone d'application
        initAttributs();
        creerMenu();
        creerVue();
    }

    /**
     * Fonction permettant d'initialiser les &eacute;l&eacute;ments graphiques Java Swing,
     * l'ajout des Actions Listener sur les &eacute;l&eacute;ments
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

        affichageAstres = new AffichageAstres(this);
    }

    /**
     * Fonction permettant de cr&eacute;er la barre de menu (JMenuBar)
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
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)dimension.getWidth();
        int height = (int)dimension.getHeight();
        setSize(width, height); //Fixe la taille par défaut
        setTitle("Planethacks : système planétaire");
        setVisible(true); //Affiche la fenêtre
        setResizable(false); //Permet de ne pas resizer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Gère la fermeture
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        jpaneGlobal.setLayout(null);
        getContentPane().setLayout(null);
        setContentPane(jpaneGlobal);

        FenetreDialogue.ouverture(this);

        affichageAstres.start();
    }

    /**
     * Retourne le modele de la Fenetre
     *
     * @return modele Model
     */
    public Modele getModele() {
        return modele;
    }

    /**
     * Retourne le composant Audio
     *
     * @return audio Audio
     */
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
     * Retourne le JMenuItem permettant de restaurer le syst&egrave;me plan&eacute;taire
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

    /**
     * Retourne le JMenuItem permettant d'activer le son
     *
     * @return Item sonOn
     */
    public JMenuItem getItemSoundOn() {
        return itemSonOn;
    }

    /**
     * Retourne le JMenuItem permettant de couper le son
     *
     * @return Item sonOff
     */
    public JMenuItem getItemSoundOff() {
        return itemSonOff;
    }

    /**
     * Retourne le JMenuItem permettant de cr&eacute;er une nouvelle Etoile
     *
     * @return Item nouvelleEtoile
     */
    public JMenuItem getItemNouvelleEtoile() {
        return itemNouvelleEtoile;
    }

    /**
     * Retourne le JMenuItem permettant de cr&eacute;er un nouveau Satellite
     *
     * @return Item nouveauSatellite
     */
    public JMenuItem getItemNouveauSatellite() {
        return itemNouveauSatellite;
    }

    /**
     * Retourne le JMenuItem permettant de supprimer un Astre
     *
     * @return Item supprimerAstre
     */
    public JMenuItem getItemSupprimerAstre() {
        return itemSupprimerAstre;
    }

    /**
     * M&eacute;thode repaint permettant l'affichage des diff&eacute;rents Astres (Etoiles et Satellites)
     * @param t le temps permettant un affichage &agrave; l'instant t
     */
    public void repaint(float t) {
        jpaneGlobal.removeAll();
        for (Etoile e : modele.getListeEtoiles()) {
            JLabel jlabastre = new JLabel(e.getImage());
            jlabastre.setBounds(e.getPositionX(), e.getPositionY(), e.getImage().getIconWidth(), e.getImage().getIconHeight());
            jpaneGlobal.add(jlabastre);
            repaintSatellite(e.getListeSatellites(), t);
        }
        jpaneGlobal.repaint();
    }

    /**
     * M&eacute;thode repaint permettant l'affichage des satellites
     * @param listSat ArrayList de Satellite &agrave; afficher
     * @param t le temps permettant un affichage &agrave; l'instant t
     */
    private void repaintSatellite(ArrayList<Satellite> listSat, float t) {
        Iterator<Satellite> it = listSat.iterator();
        while (it.hasNext()) {
            Satellite s = it.next();
            JLabel jlabsat = new JLabel(s.getImage());
            jlabsat.setBounds(s.calculPositionSatelliteX(t), s.calculPositionSatelliteY(t), s.getImage().getIconWidth(), s.getImage().getIconHeight());
            jpaneGlobal.add(jlabsat);
            repaintSatellite(s.getListeSatellites(), t);
        }
    }
}
