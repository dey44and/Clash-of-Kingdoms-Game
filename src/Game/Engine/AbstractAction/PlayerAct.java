package Game.Engine.AbstractAction;

import Game.Engine.ImplementorAction.ActImplementor;
import Game.Objects.CoinEntity;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class PlayerAct extends AbstractAct{
    public PlayerAct(ActImplementor actImplementor) {
        super(actImplementor);
    }
    @Override
    public void execute(Set<Integer> keys) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super.entityAct.ActOnKey(keys);
    }
    @Override
    public List<CoinEntity> GetCoins() {
        return super.entityAct.GetCoins();
    }
}
