import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Class which handles game audio control and playback.
 *
 * @author Keith Tramm
 *
 * @version 3/20/2024
 */
public class AudioPlayer {
    /**
     * Plays an .wav audio file.
     * @param thePath the path of the .wav file.
     */
    public static void playAudio(String thePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(thePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
