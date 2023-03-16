package Game.Engine.ImplementorAction;

import Game.Engine.CoinManager;
import Game.Engine.EnemyManager;
import Game.Engine.FireManager;
import Game.Graphics.SpriteSheet;
import Game.Objects.*;
import Game.Utilities.Vector2d;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class PlayerActImplementor extends ActImplementor {
    private PlayerEntity playerEntity;          /// referinta catre player-ul care se va misca
    private PlayerEntity enemyEntity;           /// referinta catre inamic
    private SpriteSheet sheet;                  /// sprite pentru animatii cu miscare
    private Background bg;                      /// referinta catre harta
    private List<PlaceableEntity> items;        /// referinta catre o lista cu iteme
    private List<CoinEntity> coins;             /// referinta catre o lista cu monezi
    private List<AnimatedEntity> fires;         /// referinta catre o lista cu focuri
    private int time;                           /// timpul trecut de la ultima coliziune cu focul
        /// Constructor cu argumente pentru clasa PlayerAct
    public PlayerActImplementor(PlayerEntity playerEntity, PlayerEntity enemyEntity, SpriteSheet sheet, Background bg, List<PlaceableEntity> items, List<CoinEntity> coins, List<AnimatedEntity> fires) throws Exception {
        if(playerEntity == null) throw new Exception("PlayerEntity cannot be null!");
        if(sheet == null) throw new Exception("Spritesheet cannot be null!");
        this.playerEntity = playerEntity;
        this.enemyEntity = enemyEntity;
        this.sheet = sheet;
        this.bg = bg;
        this.items = items;
        this.coins = coins;
        this.fires = fires;
        this.time = 0;
    }

    public synchronized void ActOnKey(Set<Integer> keys) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //System.out.println("---Sunt in act on key");
        Vector2d vel = new Vector2d(0, 0);
        boolean moveState = false;

        int attack = 0;
        if(keys.contains(KeyEvent.VK_SPACE)) {
            attack = 2;
        }

        for(Integer key : keys) {
            switch(key) {
                case KeyEvent.VK_W:
                    System.out.print("W ");
                    vel.SetY(vel.GetY() - 3);
                    moveState = true;
                    break;
                case KeyEvent.VK_S:
                    System.out.print("S ");
                    vel.SetY(vel.GetY() + 3);
                    moveState = true;
                    break;
                case KeyEvent.VK_A:
                    System.out.print("A ");
                    vel.SetX(vel.GetX() - 3);
                    moveState = true;
                    break;
                case KeyEvent.VK_D:
                    System.out.print("D ");
                    vel.SetX(vel.GetX() + 3);
                    moveState = true;
                    break;
            }
        }
        if(keys.contains(KeyEvent.VK_SHIFT)) {
            vel.SetX(vel.GetX() * 2);
            vel.SetY(vel.GetY() * 2);
        }
        if(vel.GetX() < 0) {
            playerEntity.setY(1 + attack);
        } else if(vel.GetX() > 0) {
            playerEntity.setY(attack);
        }
        if(vel.GetX() != 0 || vel.GetY() != 0) {
            playerEntity.setX((playerEntity.getX() + 1) % 36);
        }
        /// Actualizare pozitie
        playerEntity.UpdatePosition(vel.GetX(), vel.GetY(), this.bg, this.items);
        /// Actualizare monezi
        this.coins = CoinManager.getCoins(this.playerEntity, this.coins);
        /// Verificare coliziune foc
        this.time = FireManager.checkFireColission(this.playerEntity, this.fires, this.time);

        if(!moveState) {
            playerEntity.setX(0);
        }
        playerEntity.UpdateImage(sheet.crop(playerEntity.getX() / 3, playerEntity.getY()));
        System.out.print("\n");
    }
    public List<CoinEntity> GetCoins() {
        return this.coins;
    }
}
