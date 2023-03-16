package Game.Objects;

import Game.Graphics.SpriteSheet;

import java.awt.*;

public interface AnimatedEntity {
    void UpdateAnimation(SpriteSheet sheet);
    void Draw(Graphics g);
    void SetPosition(int x, int y);

    String getName();
}
