package Game.Objects;

import Game.Engine.CheckOnMap;
import Game.Exceptions.DrawingException;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

import static java.lang.Math.sqrt;

public class PlayerEntity extends Entity {
    private int cX;
    private int cY;
    private int score;
    private int health;
    private final Vector2d centroid;
    public PlayerEntity(BufferedImage img, int width, int height, Polygon polygon, Vector2d centroid) {
        super(img, width, height, polygon);
        this.cX = 0;
        this.cY = 0;
        this.centroid = centroid;
        this.score = 0;
        this.health = 100;
    }
    public void UpdatePosition(int x, int y, Background map, List<PlaceableEntity> items) {
        //System.out.println("---sunt in update position");
        double ip = 1;
        if(x != 0 && y != 0) {
            ip = sqrt(2);
        }
        if(CheckOnMap.isOn(this, x, y, map) && CheckOnMap.noCollision(this, x, y, items)) {
            //System.out.println("---Jucatorul e in interior!");
            this.screenPos.SetX(this.screenPos.GetX() + (int)(x / ip));
            this.screenPos.SetY(this.screenPos.GetY() + (int)(y / ip));
            //System.out.println("Player-ul se muta cu (" + (int)(x / ip) + " " +  (int)(y / ip) + ")");
        }
        //System.out.println("Player position (" + this.screenPos.GetX() + " " +  this.screenPos.GetY() + ")");
    }
    public void setX(int x) {
        this.cX = x;
    }
    public void setY(int y) {
        this.cY = y;
    }
    public int getX() {
        return this.cX;
    }
    public int getY() {
        return this.cY;
    }
    public Vector2d getCentroid() { return this.centroid; }
    public int getScore() { return this.score; }
    public int getHealth() { return this.health; }
    public void updateScore() {
        this.score++;
    }
    public void updateHealth() { this.health -= 2; }
    public void updateHealthBar(Graphics g) throws DrawingException {
        if(g == null) {
            throw new DrawingException("Eroare in desenare!");
        } else {
            g.setColor(new Color(255, 62, 62));
            g.drawRect(this.GetPosition().GetX() + 30, this.GetPosition().GetY(), 40, 10);
            g.fillRect(this.GetPosition().GetX() + 30, this.GetPosition().GetY(), (int)((double)this.health * 0.4), 10);
        }
    }
}
