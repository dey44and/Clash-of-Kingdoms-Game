package Game.Engine.AbstractAction;

import Game.Engine.ImplementorAction.ActImplementor;
import Game.Objects.CoinEntity;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public abstract class AbstractAct {
    protected ActImplementor entityAct;
    public AbstractAct(ActImplementor actImplementor) {
        this.entityAct = actImplementor;
    }
    abstract public void execute(Set<Integer> keys) throws UnsupportedAudioFileException, LineUnavailableException, IOException;

    abstract public List<CoinEntity> GetCoins();
}
