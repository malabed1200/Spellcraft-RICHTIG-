import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundTest {
    public static void main(String[] args) {
        String pfad = "Spellcraft/Sounds/1.wav"; // Pfad zur Musikdatei
        playSound(pfad);
    }

    public static void playSound(String pfad) {
        File file = new File(pfad);

        if (!file.exists()) {
            System.err.println("Fehler: Datei existiert nicht -> " + file.getAbsolutePath());
            return;
        }

        try {
            AudioFileFormat format = AudioSystem.getAudioFileFormat(file);
            System.out.println("File format: " + format.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}