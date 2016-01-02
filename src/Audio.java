import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * <b>Classe permettant de cr&eacute;er un flux audio.</b>
 * Un objet Audio est caract&eacute;ris&eacute; par les informations suivantes :
 * <ul>
 * <li>Un AudioPlayer.</li>
 * <li>Un AudioStream.</li>
 * </ul>
 */
public class Audio {

    private AudioPlayer p;
    private AudioStream as;

    /**
     * Constructeur de Audio
     * @see Audio#p
     * @see Audio#as
     */
    public Audio(){
        p = AudioPlayer.player;
    }

    /**
     * Méthode permettant de créer un flux audio à l'aide d'un fichier wav
     * et de le lire
     * @param nomFichierAudio Le chemin vers le fichier audio (wav)
     */
    public void launchSound(String nomFichierAudio) {
        try {
            as = new AudioStream(new FileInputStream(nomFichierAudio));
            p.start(as);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    /**
     * Méthode permettant de stopper le flux audio
     */
    public void stopSound(){
        p.stop(as);
    }
}
