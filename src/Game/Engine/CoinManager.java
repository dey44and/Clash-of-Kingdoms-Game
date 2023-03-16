package Game.Engine;

import Game.Objects.CoinEntity;
import Game.Objects.PlayerEntity;
import Game.SoundManager.SoundImplements.CoinCollect;
import Game.Utilities.GeometryTranform;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinManager {
    public static List<CoinEntity> getCoins(PlayerEntity playerEntity, List<CoinEntity> coins) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        List<CoinEntity> items = new ArrayList<CoinEntity>();
        for(CoinEntity coin : coins) {
            // Determinare poligon cu offset
            Polygon polygon = GeometryTranform.applyOffset(coin.getPolygon(), coin.GetPosition());
            // Determinare coliziune cu fiecare punct
            List<Vector2d> playerPoints = playerEntity.getPolygon().getPoints();
            boolean answer = true;
            for(Vector2d point : playerPoints) {
                answer = !polygon.pointInside(point, playerEntity.GetPosition());
                if(!answer) break;
            }
            // Daca exista coliziune, atunci elimin moneda
            if(!answer) {
                playerEntity.updateScore();
                System.out.println("Moneda gasita!");
                CoinCollect coinCollect = new CoinCollect();
                coinCollect.getSoundEffect();
            } else {
                items.add(coin);
            }
        }
        return items;
    }
}
