import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * <b>Classe permettant de générer les fichiers XML de sauvegarde :</b>
 */
public final class XMLTools {
    private XMLTools() {}

    /**
     * Serialisation d'un objet dans un fichier
     * @param object objet a s&eacute;rialiser
     * @param fileName chemin du fichier
     */
    public static void encodeToFile(Object object, String fileName) throws
            IOException {
        // ouverture de l'encodeur vers le fichier
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        try {
            // serialisation de l'objet
            encoder.writeObject(object);
            encoder.flush();
        } finally {
            // fermeture de l'encodeur
            encoder.close();
        }
    }

    /**
     * Deserialisation d'un objet depuis un fichier
     * @param fileName chemin du fichier
     */
    public static Object decodeFromFile(String fileName) throws
            IOException {
        Object object = null;
        // ouverture de decodeur
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        try {
            // deserialisation de l'objet
            object = decoder.readObject();
        } finally {
            // fermeture du decodeur
            decoder.close();
        }
        return object;
    }

}
