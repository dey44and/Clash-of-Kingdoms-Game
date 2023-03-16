package Game.Engine;

import Game.Objects.Background;
import Game.Objects.PlaceableEntity;
import Game.Objects.PlayerEntity;
import Game.Utilities.GeometryTranform;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class CheckOnMap {
    public static boolean isOn(PlayerEntity playerEntity, int x, int y, Background map) {
        //System.out.println("---Sunt in check on map");
        Vector2d pos = new Vector2d(playerEntity.GetPosition().GetX() + x, playerEntity.GetPosition().GetY() + y);
        Polygon polygon = map.getPolygon();
        return polygon.pointInside(playerEntity.getCentroid(), pos) && pos.GetX() + playerEntity.getCentroid().GetX() >= 25 && pos.GetX() + playerEntity.getCentroid().GetX() <= 875;
    }
    public static boolean noCollision(PlayerEntity playerEntity, int x, int y, List<PlaceableEntity> items) {
        // Voi lua fiecare punct din playerEntity si voi testa coliziunea cu poligonul fiecarui item
        Vector2d pos = new Vector2d(playerEntity.GetPosition().GetX() + x, playerEntity.GetPosition().GetY() + y);
        boolean answer = true;
        for(PlaceableEntity item : items) {
            // Determinare poligon cu offset
            Polygon polygon = GeometryTranform.applyOffset(item.getPolygon(), item.GetPosition());
            // Determinare coliziune cu fiecare punct
            List<Vector2d> playerPoints = playerEntity.getPolygon().getPoints();
            for(Vector2d point : playerPoints) {
                answer = !polygon.pointInside(point, pos);
                if(!answer) break;
            }
            if(!answer) break;
        }
        if(!answer) System.out.println("Coliziune!");
        return answer;
    }
}
