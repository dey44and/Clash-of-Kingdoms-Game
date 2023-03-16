package Game.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Polygon {
    private final List<Vector2d> points;
    public Polygon() {
        points = new ArrayList<>();
    }
    public void addVec2d(Vector2d v) {
        points.add(v);
    }
    public List<Vector2d> getPoints() {
        return points;
    }
    public boolean pointInside(Vector2d point, Vector2d offset) {
        int xM = point.GetX() + offset.GetX();
        int yM = point.GetY() + offset.GetY();

        int counter = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            if(points.get(i).GetX() < xM && xM < points.get(i + 1).GetX() || points.get(i).GetX() > xM && xM > points.get(i + 1).GetX()) {
                double t = (double)(xM - points.get(i + 1).GetX()) / (double)(points.get(i).GetX() - points.get(i + 1).GetX());
                double yC = t * points.get(i).GetY() + (1 - t) * points.get(i + 1).GetY();
                if(Math.abs(t - yC) < 1e-9) return true;
                else if(yM - yC > 1e-9) counter++;
            }
            if(points.get(i).GetX() == xM && points.get(i).GetY() >= yM && points.get(i + 1).GetY() <= yM) return true;
            if(points.get(i).GetX() == xM && points.get(i).GetY() <= yM) {
                if(points.get(i).GetY() == yM) return true;
                if(points.get(i + 1).GetX() == xM) {
                    if(points.get(i).GetY() <= yM && yM <= points.get(i + 1).GetY() ||
                    points.get(i).GetY() >= yM && yM >= points.get(i + 1).GetY())
                        return true;
                } else if(points.get(i + 1).GetX() > xM) counter++;
                if(i > 1.e-9) if(points.get(i - 1).GetX() > xM) counter++;
            }
        }
        //System.out.println("Numarul de intersectii: " + counter);
        if(counter % 2 == 1) return true;
        return false;
    }
}
