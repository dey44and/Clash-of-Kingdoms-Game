package Game.SoundManager.SoundImplements;

import Game.Exceptions.SoundException;
import Game.SoundManager.SoundTypes;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class CoinCollect implements SoundTypes {
    public void getSoundEffect() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // Muzica
        // Open an audio input stream.
        URL url = this.getClass().getClassLoader().getResource("Sounds/get_coin.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        if(audioIn == null) {
            throw new SoundException("Eroare in deschiderea fisierului!");
        } else {
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        }
    }
}
