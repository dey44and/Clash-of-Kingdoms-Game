package Game.Objects.Factory;

import Game.Graphics.ImageLoader;
import Game.Graphics.SpriteSheet;
import Game.Objects.*;
import Game.Utilities.Polygon;
import Game.Utilities.Vector2d;

import java.util.Map;

public class EntityFactory extends AbstractFactory {
    public Entity createEntity(String entityName, Map<String, SpriteSheet> sprites) {
        Entity object = null;
        switch(entityName) {
            case "Background":
                Polygon polygon = new Polygon();
                polygon.addVec2d(new Vector2d(0, 270));
                polygon.addVec2d(new Vector2d(52, 260));
                polygon.addVec2d(new Vector2d(52, 238));
                polygon.addVec2d(new Vector2d(148, 232));
                polygon.addVec2d(new Vector2d(148, 248));
                polygon.addVec2d(new Vector2d(294, 240));
                polygon.addVec2d(new Vector2d(443, 234));
                polygon.addVec2d(new Vector2d(563, 206));
                polygon.addVec2d(new Vector2d(580, 225));
                polygon.addVec2d(new Vector2d(680, 238));
                polygon.addVec2d(new Vector2d(766, 223));
                polygon.addVec2d(new Vector2d(775, 238));
                polygon.addVec2d(new Vector2d(898, 234));
                polygon.addVec2d(new Vector2d(898, 515));
                polygon.addVec2d(new Vector2d(752, 520));
                polygon.addVec2d(new Vector2d(744, 494));
                polygon.addVec2d(new Vector2d(703, 496));
                polygon.addVec2d(new Vector2d(694, 523));
                polygon.addVec2d(new Vector2d(610, 532));
                polygon.addVec2d(new Vector2d(540, 516));
                polygon.addVec2d(new Vector2d(472, 516));
                polygon.addVec2d(new Vector2d(467, 488));
                polygon.addVec2d(new Vector2d(430, 490));
                polygon.addVec2d(new Vector2d(432, 524));
                polygon.addVec2d(new Vector2d(382, 524));
                polygon.addVec2d(new Vector2d(380, 517));
                polygon.addVec2d(new Vector2d(317, 520));
                polygon.addVec2d(new Vector2d(256, 534));
                polygon.addVec2d(new Vector2d(252, 500));
                polygon.addVec2d(new Vector2d(226, 460));
                polygon.addVec2d(new Vector2d(174, 470));
                polygon.addVec2d(new Vector2d(153, 473));
                polygon.addVec2d(new Vector2d(133, 458));
                polygon.addVec2d(new Vector2d(122, 440));
                polygon.addVec2d(new Vector2d(104, 450));
                polygon.addVec2d(new Vector2d(82, 530));
                polygon.addVec2d(new Vector2d(0, 536));
                polygon.addVec2d(new Vector2d(0, 270));
                object = new Background(ImageLoader.LoadImage("/Images/background/bg.png"), 900, 600, polygon);
                break;
            case "PlayerTower":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(0, 145));
                polygon.addVec2d(new Vector2d(0, 122));
                polygon.addVec2d(new Vector2d(10, 114));
                polygon.addVec2d(new Vector2d(10, 102));
                polygon.addVec2d(new Vector2d(0, 86));
                polygon.addVec2d(new Vector2d(10, 72));
                polygon.addVec2d(new Vector2d(0, 63));
                polygon.addVec2d(new Vector2d(0, 50));
                polygon.addVec2d(new Vector2d(8, 40));
                polygon.addVec2d(new Vector2d(9, 20));
                polygon.addVec2d(new Vector2d(38, 0));
                polygon.addVec2d(new Vector2d(94, 0));
                polygon.addVec2d(new Vector2d(128, 22));
                polygon.addVec2d(new Vector2d(128, 40));
                polygon.addVec2d(new Vector2d(140, 56));
                polygon.addVec2d(new Vector2d(127, 70));
                polygon.addVec2d(new Vector2d(138, 82));
                polygon.addVec2d(new Vector2d(138, 100));
                polygon.addVec2d(new Vector2d(128, 106));
                polygon.addVec2d(new Vector2d(128, 112));
                polygon.addVec2d(new Vector2d(140, 122));
                polygon.addVec2d(new Vector2d(136, 144));
                polygon.addVec2d(new Vector2d(77, 163));
                polygon.addVec2d(new Vector2d(30, 160));
                polygon.addVec2d(new Vector2d(0, 145));
                object = new PlaceableEntity(ImageLoader.LoadImage("/Images/simple/player_tower.png"), 154, 173, polygon);
                break;
            case "EnemyTower":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(0, 145));
                polygon.addVec2d(new Vector2d(0, 122));
                polygon.addVec2d(new Vector2d(10, 114));
                polygon.addVec2d(new Vector2d(10, 102));
                polygon.addVec2d(new Vector2d(0, 86));
                polygon.addVec2d(new Vector2d(10, 72));
                polygon.addVec2d(new Vector2d(0, 63));
                polygon.addVec2d(new Vector2d(0, 50));
                polygon.addVec2d(new Vector2d(8, 40));
                polygon.addVec2d(new Vector2d(9, 20));
                polygon.addVec2d(new Vector2d(38, 0));
                polygon.addVec2d(new Vector2d(94, 0));
                polygon.addVec2d(new Vector2d(128, 22));
                polygon.addVec2d(new Vector2d(128, 40));
                polygon.addVec2d(new Vector2d(140, 56));
                polygon.addVec2d(new Vector2d(127, 70));
                polygon.addVec2d(new Vector2d(138, 82));
                polygon.addVec2d(new Vector2d(138, 100));
                polygon.addVec2d(new Vector2d(128, 106));
                polygon.addVec2d(new Vector2d(128, 112));
                polygon.addVec2d(new Vector2d(140, 122));
                polygon.addVec2d(new Vector2d(136, 144));
                polygon.addVec2d(new Vector2d(77, 163));
                polygon.addVec2d(new Vector2d(30, 160));
                polygon.addVec2d(new Vector2d(0, 145));
                object = new PlaceableEntity(ImageLoader.LoadImage("/Images/simple/enemy_tower.png"), 154, 173, polygon);
                break;
            case "FireEntity":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(4, 100));
                polygon.addVec2d(new Vector2d(20, 70));
                polygon.addVec2d(new Vector2d(46, 48));
                polygon.addVec2d(new Vector2d(55, 33));
                polygon.addVec2d(new Vector2d(65, 48));
                polygon.addVec2d(new Vector2d(76, 68));
                polygon.addVec2d(new Vector2d(88, 88));
                polygon.addVec2d(new Vector2d(96, 100));
                polygon.addVec2d(new Vector2d(4, 100));
                object = new FireEntity(sprites.get(entityName).crop(0, 0), 100, 100, polygon);
                break;
            case "CoinEntity":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(50, 25));
                polygon.addVec2d(new Vector2d(75, 50));
                polygon.addVec2d(new Vector2d(50, 75));
                polygon.addVec2d(new Vector2d(25, 50));
                polygon.addVec2d(new Vector2d(50, 25));
                object = new CoinEntity(sprites.get(entityName).crop(0, 0), 100, 100, polygon);
                break;
            case "Arthur":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(24, 14));
                polygon.addVec2d(new Vector2d(84, 14));
                polygon.addVec2d(new Vector2d(76, 80));
                polygon.addVec2d(new Vector2d(32, 80));
                polygon.addVec2d(new Vector2d(24, 14));
                object = new PlayerEntity(sprites.get(entityName).crop(0, 0), 100, 100, polygon, new Vector2d(52, 80));
                break;
            case "Pirate":
                polygon = new Polygon();
                polygon.addVec2d(new Vector2d(32, 22));
                polygon.addVec2d(new Vector2d(96, 22));
                polygon.addVec2d(new Vector2d(92, 92));
                polygon.addVec2d(new Vector2d(40, 92));
                polygon.addVec2d(new Vector2d(32, 22));
                object = new PlayerEntity(sprites.get(entityName).crop(0, 0), 100, 100, polygon, new Vector2d(52, 80));
                break;
        }
        return object;
    }
}
