package Game.Objects;

import Game.Utilities.Polygon;

import java.awt.image.BufferedImage;

public class PlaceableEntity extends Entity{
    public PlaceableEntity(BufferedImage img, int width, int height, Polygon polygon) {
        super(img, width, height, polygon);
    }
}
