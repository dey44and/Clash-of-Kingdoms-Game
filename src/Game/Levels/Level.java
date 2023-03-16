package Game.Levels;

import Game.Engine.CoinManager;
import Game.Graphics.SpriteSheet;
import Game.Objects.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Level {
    private Background bg;
    private List<PlaceableEntity> placeableEntityList;
    private List<AnimatedEntity> animatedEntitylist;
    private List<CoinEntity> coinsList;
    private PlayerEntity user, enemy;
    public Level(Background bg, List<PlaceableEntity> placeableEntityList, List<AnimatedEntity> animatedEntitylist, List<CoinEntity> coinsList, PlayerEntity user, PlayerEntity enemy) {
        this.bg = bg;
        this.placeableEntityList = placeableEntityList;
        this.animatedEntitylist = animatedEntitylist;
        this.user = user;
        this.enemy = enemy;
        this.coinsList = coinsList;
    }
    public void drawObjects(Graphics g) {
        bg.Draw(g);
        for(PlaceableEntity entity : placeableEntityList) {
            entity.Draw(g);
        }
        for(AnimatedEntity entity : animatedEntitylist) {
            entity.Draw(g);
        }
        for(CoinEntity entity : coinsList) {
            entity.Draw(g);
        }
        user.Draw(g);
        enemy.Draw(g);
    }
    public void updateAnimations(Map<String, SpriteSheet> list) {
        for(int i = 0; i < animatedEntitylist.size(); i++) {
            animatedEntitylist.get(i).UpdateAnimation(list.get(animatedEntitylist.get(i).getName()));
        }
        for(int i = 0; i < coinsList.size(); i++) {
            coinsList.get(i).UpdateAnimation(list.get(coinsList.get(i).getName()));
        }
    }
    public PlayerEntity GetUser() {
        return this.user;
    }
    public PlayerEntity GetEnemy() {
        return this.enemy;
    }
    public Background GetBackground() {return this.bg; }
    public List<PlaceableEntity> GetItems() {return this.placeableEntityList; }
    public List<CoinEntity> GetCoins() {return this.coinsList; }
    public List<AnimatedEntity> GetFires() {return this.animatedEntitylist; }
    public void UpdateCoins(List<CoinEntity> coins) {
        this.coinsList = coins;
    }
}
