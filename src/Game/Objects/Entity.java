package Game.Objects;

import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Entity {
    private final int width;
    private final int height;
    protected final Vector2d screenPos;
    protected final Polygon polygon;
    protected BufferedImage img;
    Entity(BufferedImage img, int width, int height, Polygon polygon) {
        this.width = width;
        this.height = height;
        this.screenPos = new Vector2d();
        this.img = img;
        this.polygon = polygon;
    }
    public Vector2d GetPosition() {
        return this.screenPos;
    }
    public Polygon getPolygon() {
        return this.polygon;
    }
    public void SetPosition(int x, int y) {
        this.screenPos.SetX(x);
        this.screenPos.SetY(y);
    }
    public void Draw(Graphics g) {
        try {
            g.drawImage(img, screenPos.GetX(), screenPos.GetY(), width, height, null);
            // Desenare polygon player
            List<Vector2d> points = polygon.getPoints();
            if(points.size() > 0) {
                g.setColor(new Color(255, 255, 255));
                for (int i = 0; i < points.size() - 1; i++) {
                    g.drawLine(points.get(i).GetX() + screenPos.GetX(), points.get(i).GetY() + screenPos.GetY(), points.get(i + 1).GetX() + screenPos.GetX(), points.get(i + 1).GetY() + screenPos.GetY());
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateImage(BufferedImage img) {
        this.img = img;
    }
}
