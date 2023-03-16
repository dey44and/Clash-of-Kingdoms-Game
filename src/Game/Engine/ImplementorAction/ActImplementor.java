package Game.Engine.ImplementorAction;

import Game.Objects.CoinEntity;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public abstract class ActImplementor {
    abstract public void ActOnKey(Set<Integer> keys) throws UnsupportedAudioFileException, LineUnavailableException, IOException;
    abstract public List<CoinEntity> GetCoins();
}
