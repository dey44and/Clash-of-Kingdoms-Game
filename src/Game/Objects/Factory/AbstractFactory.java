package Game.Objects.Factory;

import Game.Graphics.SpriteSheet;
import Game.Objects.Entity;

import java.util.Map;

public abstract class AbstractFactory {
    abstract public Entity createEntity(String entityName, Map<String, SpriteSheet> sprites);
}
