package Game.Engine;

import Game.Objects.PlayerEntity;
import Game.Utilities.GeometryTranform;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import java.util.List;

public class EnemyManager {
    public static boolean checkCollision(PlayerEntity playerEntity, PlayerEntity enemyEntity) {
        boolean answer = false;
        // Determinare poligon cu offset
        Polygon polygon = GeometryTranform.applyOffset(enemyEntity.getPolygon(), enemyEntity.GetPosition());
        // Determinare coliziune cu fiecare punct
        List<Vector2d> playerPoints = playerEntity.getPolygon().getPoints();
        for(Vector2d point : playerPoints) {
            answer = answer | polygon.pointInside(point, playerEntity.GetPosition());
            if(answer) break;
        }
        return answer;
    }
}
