package Game.SoundManager;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface SoundTypes {
    void getSoundEffect() throws IOException, UnsupportedAudioFileException, LineUnavailableException;
}
