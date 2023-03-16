package Game.Levels;

import Game.Objects.*;

import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {
    private Background bg;
    private final List<PlaceableEntity> placeableEntityList;
    private final List<AnimatedEntity> animatedEntityList;
    private final List<CoinEntity> coinsList;
    private PlayerEntity user, enemy;
    public LevelBuilder() {
        this.bg = null;
        this.user = null;
        this.enemy = null;
        this.placeableEntityList = new ArrayList<>();
        this.animatedEntityList = new ArrayList<>();
        this.coinsList = new ArrayList<>();
    }
    public void setBackground(Background bg) {
        if(this.bg == null) {
            bg.SetPosition(0, 0);
            this.bg = bg;
        }
    }
    public void addPlaceableEntity(PlaceableEntity placeableEntity, int x, int y) {
        placeableEntity.SetPosition(x, y);
        placeableEntityList.add(placeableEntity);
    }
    public void addAnimatedEntity(AnimatedEntity fire, int x, int y) {
        fire.SetPosition(x, y);
        animatedEntityList.add(fire);
    }
    public void addCoin(CoinEntity coin, int x, int y) {
        coin.SetPosition(x, y);
        coinsList.add(coin);
    }
    public void addPlayer(PlayerEntity playerEntity, int x, int y) {
        if(this.user == null) {
            playerEntity.SetPosition(x, y);
            this.user = playerEntity;
        }
    }
    public void addEnemy(PlayerEntity playerEntity, int x, int y) {
        if(this.enemy == null) {
            playerEntity.SetPosition(x, y);
            this.enemy = playerEntity;
        }
    }
    public Level buildLevel() {
        return new Level(this.bg, this.placeableEntityList, this.animatedEntityList, this.coinsList, this.user, this.enemy);
    }
}
