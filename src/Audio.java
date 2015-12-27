import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by quentin on 27/12/15.
 */
public class Audio {

    private AudioPlayer p;
    private AudioStream as;

    public Audio(){
        p = AudioPlayer.player;
    }

    public void genererSon(String nomFichierAudio) {
        try {
            as = new AudioStream(new FileInputStream(nomFichierAudio));
            p.start(as);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void stopSon(){
        p.stop(as);
    }
}
