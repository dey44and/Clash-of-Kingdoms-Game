package Game.Objects;

import Game.Graphics.SpriteSheet;
import Game.Utilities.Polygon;

import java.awt.image.BufferedImage;

public class CoinEntity extends Entity  implements AnimatedEntity {
    private int x;
    private int y;
    private final String name;
    private int cronometer;
    public CoinEntity(BufferedImage img, int width, int height, Polygon polygon) {
        super(img, width, height, polygon);
        this.x = 0;
        this.y = 0;
        this.cronometer = 0;
        this.name = "CoinEntity";
    }
    public void UpdateAnimation(SpriteSheet sheet) {
        this.cronometer++;
        if(this.cronometer == 5) {
            this.x++;
            if(this.x == 6) {
                this.x = 0;
            }
            this.cronometer = 0;
        }
        img = sheet.crop(this.x, this.y);
    }
    public String getName() {
        return this.name;
    }
}