package Game.Engine;

import Game.Objects.AnimatedEntity;
import Game.Objects.CoinEntity;
import Game.Objects.FireEntity;
import Game.Objects.PlayerEntity;
import Game.SoundManager.SoundImplements.HurtMusic;
import Game.SoundManager.SoundTypes;
import Game.Utilities.GeometryTranform;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class FireManager {
    public static int checkFireColission(PlayerEntity playerEntity, List<AnimatedEntity> items, int time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        int new_time = 0;
        for (AnimatedEntity item : items) {
            FireEntity fire = (FireEntity) item;
            // Determinare poligon cu offset
            Polygon polygon = GeometryTranform.applyOffset(fire.getPolygon(), fire.GetPosition());
            // Determinare coliziune cu fiecare punct
            List<Vector2d> playerPoints = playerEntity.getPolygon().getPoints();
            boolean answer = true;
            for(Vector2d point : playerPoints) {
                answer = !polygon.pointInside(point, playerEntity.GetPosition());
                if(!answer) break;
            }
            // Daca exista coliziune, actualizez
            if(!answer) {
                playerEntity.updateHealth();
                new_time = LocalDateTime.now().toLocalTime().toSecondOfDay();
                if(new_time - time > 1) {
                    HurtMusic hurtMusic = new HurtMusic();
                    hurtMusic.getSoundEffect();
                }
            }
        }
        return new_time;
    }
}
