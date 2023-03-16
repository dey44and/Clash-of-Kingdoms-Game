package Game.Objects;

import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import java.awt.image.BufferedImage;

public class Background extends Entity{
    public Background(BufferedImage img, int width, int height, Polygon polygon) {
        super(img, width, height, polygon);
    }
}
