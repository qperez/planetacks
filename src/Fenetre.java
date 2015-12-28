import javax.swing.*;

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
public class Fenetre extends JFrame{

    //Constante permettant de parametrer le chemin relatif aux ressources images nécessaires
    private static final String PATH_RESSOURCES_IMG = "./resources/img/";
    private static final String PATH_RESSOURCES_SOUNDS = "./resources/sounds/";


    private Modele modele;

    private JMenuItem itemQuitter;
    private JMenuItem itemRestaurer;
    private JMenuItem itemSauvegarder;

    private JMenuItem itemNouvelleEtoile;
    private JMenuItem itemNouveauSatellite;

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
    public Fenetre(Modele modele){
        this.modele = modele;
        setIconImage(new ImageIcon(PATH_RESSOURCES_IMG+"icone_appli.jpg").getImage()); //Affiche une icone d'application
        initAttributs();
        creerVue();
        creerMenu();
        setSize(1024,768); //Fixe la taille par défaut
        setTitle("Planethacks : système planétaire");
        // add(new JLabel(new ImageIcon(PATH_RESSOURCES_IMG+"fond_voielact_jpanel.jpg"))); //ajout de l'image de fond de la Jframe
        add(new JLabel(new ImageIcon(PATH_RESSOURCES_IMG+"backscreen.jpg")));
        setVisible(true); //Affiche la fenêtre
        setResizable(false); //Permet de ne pas resizer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Gère la fermeture
        //audio.launchSound(PATH_RESSOURCES_SOUNDS+"star_wars_theme.wav");
    }

    /**
     * Fonction permettant d'initialiser les éléments graphiques Java Swing,
     * ainsi que l'ajout des Actions Listener sur les éléments
     * */
    private void initAttributs() {
        itemQuitter = new JMenuItem("Quitter", new ImageIcon(PATH_RESSOURCES_IMG+"exit.png"));
        itemRestaurer = new JMenuItem("Nouveau système planétaire");
        itemSauvegarder = new JMenuItem("Sauvegarder le système planétaire");

        itemNouvelleEtoile = new JMenuItem("Nouvelle étoile");
        itemNouveauSatellite = new JMenuItem("Nouveau satellite");

        itemSonOn = new JMenuItem("Activer le son");
        itemSonOff = new JMenuItem("Couper le son");

        audio = new Audio();
    }

    /**
     * Fonction permettant de créer la barre de menu (JMenuBar)
     * @return la barre de menu JMenuBar
     * */
    private JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuOptions = new JMenu("Outils");
        JMenu menuSon = new JMenu("Son");

        menuFichier.add(itemRestaurer);
        menuFichier.add(itemSauvegarder);
        menuFichier.add(itemQuitter);

        menuOptions.add(itemNouvelleEtoile);
        menuOptions.add(itemNouveauSatellite);

        menuSon.add(itemSonOn);
        menuSon.add(itemSonOff);

        menuBar.add(menuFichier);
        menuBar.add(menuOptions);
        menuBar.add(menuSon);

        setJMenuBar(menuBar);

        //Création du controleur du menu et ajout des actions listener sur les items
        controleurMenu = new ControleurMenu(this, modele);
        itemRestaurer.addActionListener(controleurMenu);
        itemQuitter.addActionListener(controleurMenu);

        itemNouveauSatellite.addActionListener(controleurMenu);
        itemNouvelleEtoile.addActionListener(controleurMenu);

        itemSonOn.addActionListener(controleurMenu);
        itemSonOff.addActionListener(controleurMenu);

        return menuBar;
    }

    /**
     * Fonction permettant d'ajouter les différents éléments graphiques à la JFrame
     * */
    private void creerVue() {
        JPanel jpanGlobal = new JPanel(); //JPanel global de la fenêtre
        setContentPane(jpanGlobal);
    }

    /**
     * Fonction r&eacute;initialisant l'affichage de la JFrame
     */
    /* public void restaurationAffichage(Modele modele) {
        setVisible(false);
        initAttributs();
        getContentPane().removeAll();
        creerVue();
        creerMenu();
        setSize(1024,768); //Fixe la taille par défaut
        //add(new JLabel(new ImageIcon(PATH_RESSOURCES_IMG+"fond_voielact_jpanel.jpg")));
        add(new JLabel(new ImageIcon(PATH_RESSOURCES_IMG+"backscreen.jpg")));
        setVisible(true);
    } */

    public Modele getModele() {
        return modele;
    }

    public Audio getAudio() {
        return audio;
    }

    /**
     * Retourne le JMenuItem permettant de quitter l'application
     * @return Item quitter
     */
    public JMenuItem getItemQuitter() {
        return itemQuitter;
    }

    /**
     * Retourne le JMenuItem permettant de restaurer le système planétaire
     * @return Item restaurer
     */
    public JMenuItem getItemRestaurer() {
        return itemRestaurer;
    }

    /**
     * Retourne le JMenuItem permettant de sauvegarder
     * @return Item sauvegarder
     */
    public JMenuItem getItemSauvegarder() {
        return itemSauvegarder;
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

}
