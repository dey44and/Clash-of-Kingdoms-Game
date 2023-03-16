package Game.Utilities;

import java.util.List;

public class GeometryTranform {
    public static Polygon applyOffset(Polygon polygon, Vector2d offset) {
        Polygon result = new Polygon();
        List<Vector2d> points = polygon.getPoints();
        for(Vector2d point : points) {
            result.addVec2d(new Vector2d(point.GetX() + offset.GetX(), point.GetY() + offset.GetY()));
        }
        return result;
    }
}
