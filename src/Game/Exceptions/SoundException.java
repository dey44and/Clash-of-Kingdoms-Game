package Game.Exceptions;

import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundException extends UnsupportedAudioFileException {
    public SoundException(String errorMessage) {
        super(errorMessage);
    }
}
