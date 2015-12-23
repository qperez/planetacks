import javax.swing.*;
import java.awt.*;

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
    private static final String PATH_RESSOURCES_IMG = "./resources/img/";

    private Modele modele;

    private JMenuItem itemQuitter;
    private JMenuItem itemNouveauSysteme;
    private JMenuItem itemSauvegarder;

    public Fenetre(Modele modele){
        this.modele = modele;
        setIconImage(new ImageIcon(PATH_RESSOURCES_IMG+"icone_appli.jpg").getImage()); //Affiche une icone d'application
        initAttributs();
        creerVue();
        creerMenu();
        setSize(1000,700); //Fixe la taille par défaut
        setTitle("Planethacks : système planétaire");
        add(new JLabel(new ImageIcon(PATH_RESSOURCES_IMG+"fond_voielact_jpanel.jpg"))); //ajout de l'image de fond de la Jframe
        setVisible(true); //Affiche la fenêtre
        setResizable(false); //Permet de ne pas resizer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Gère la fermeture

    }

    private void initAttributs() {
        itemQuitter = new JMenuItem("Quitter", new ImageIcon(PATH_RESSOURCES_IMG+"exit.png"));
        itemNouveauSysteme = new JMenuItem("Nouveau système planétaire");
        itemSauvegarder = new JMenuItem("Sauvegarder le système planétaire");
    }

    private JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuOptions = new JMenu("Outils");
        JMenu menuSon = new JMenu("Son");

        menuFichier.add(itemSauvegarder);
        menuFichier.add(itemNouveauSysteme);
        menuFichier.add(itemQuitter);

        menuBar.add(menuFichier);
        menuBar.add(menuOptions);
        menuBar.add(menuSon);

        setJMenuBar(menuBar);
        return menuBar;
    }

    private void creerVue() {
        JPanel jpanGlobal = new JPanel(); //JPanel global de la fenêtre
        setContentPane(jpanGlobal);
    }

}
