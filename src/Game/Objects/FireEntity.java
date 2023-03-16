package Game.Objects;

import Game.Graphics.SpriteSheet;
import Game.Utilities.Polygon;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FireEntity extends Entity implements AnimatedEntity {
    private int x;
    private int y;
    private final String name;
    public FireEntity(BufferedImage img, int width, int height, Polygon polygon) {
        super(img, width, height, polygon);
        this.x = 0;
        this.y = 0;
        this.name = "FireEntity";
    }
    public void UpdateAnimation(SpriteSheet sheet) {
        this.x++;
        if(this.x == 8) {
            this.x = 0;
            this.y++;
        }
        if(this.y == 8) {
            this.y = 0;
        }
        img = sheet.crop(this.x, this.y);
    }
    public String getName() {
        return this.name;
    }
}
