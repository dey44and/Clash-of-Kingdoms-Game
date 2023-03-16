package Game.Frames.States;

import Game.Database.SQLGetData;
import Game.Database.SQLUpdateData;
import Game.Engine.AbstractAction.AbstractAct;
import Game.Engine.AbstractAction.PlayerAct;
import Game.Engine.EnemyManager;
import Game.Engine.ImplementorAction.PlayerActImplementor;
import Game.Engine.KeyHandler;
import Game.Exceptions.DrawingException;
import Game.Frames.FrameFinitState;
import Game.Game;
import Game.GameWindow.GameWindow;
import Game.Graphics.ImageLoader;
import Game.Graphics.ScoreBoard;
import Game.Graphics.SpriteSheet;
import Game.Levels.Level;
import Game.Levels.LevelBuilder;
import Game.Objects.*;
import Game.Objects.Factory.EntityFactory;
import Game.SoundManager.SoundImplements.WinnerMusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelState extends FrameFinitState {
    private KeyHandler keyHandler; /*!< Referinta catre recorder-ul de evenimente. */
    //private PlayerActImplementor playerAct;
    private AbstractAct playerAct;      /*!< Referinta catre handler-ul de evenimente. */
    private Level level;                /*!< Referinta catre nivelul curent. */
    private ScoreBoard scoreBoard;      /*!< Referinta catre scoreboard. */
    private Game game;
    private final Map<String, SpriteSheet> sprites;
    /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
    SpriteSheet arthur_sheet = new SpriteSheet(ImageLoader.LoadImage("/Images/simple/arthur_sprite.png"));
    SpriteSheet fire_sheet = new SpriteSheet(ImageLoader.LoadImage("/Images/simple/fire_sprite.png"));
    SpriteSheet coin_sheet = new SpriteSheet(ImageLoader.LoadImage("/Images/simple/coin_sprite.png"));
    SpriteSheet pirate_sheet = new SpriteSheet(ImageLoader.LoadImage("/Images/simple/pirate_sprite.png"));
    public LevelState(Game game) {
        sprites = new HashMap<>();
        sprites.put("FireEntity", fire_sheet);
        sprites.put("CoinEntity", coin_sheet);
        sprites.put("Arthur", arthur_sheet);
        sprites.put("Pirate", pirate_sheet);

        scoreBoard = new ScoreBoard();
        this.game = game;
    }
    public void initState(GameWindow wnd) throws Exception {
        /// Se construieste harta jocului
        LevelBuilder levelBuilder = new LevelBuilder();
        EntityFactory entityFactory = new EntityFactory();

        levelBuilder.setBackground((Background) entityFactory.createEntity("Background", sprites));
        //levelBuilder.addPlaceableEntity( new PlaceableEntity(ImageLoader.LoadImage("/Images/simple/level1.png"), 390, 50));
        /// Se incarca turnurile
        levelBuilder.addPlaceableEntity((PlaceableEntity) entityFactory.createEntity("PlayerTower", sprites), 450, 80);
        levelBuilder.addPlaceableEntity((PlaceableEntity) entityFactory.createEntity("EnemyTower", sprites), 753, 360);
        /// Se incarca animatia de foc
        levelBuilder.addAnimatedEntity((AnimatedEntity) entityFactory.createEntity("FireEntity", sprites), 500, 400);


        /// Se incarca animatie de monezi
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 100, 200);
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 200, 200);
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 500, 400);
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 800, 250);
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 550, 250);
        levelBuilder.addCoin((CoinEntity) entityFactory.createEntity("CoinEntity", sprites), 200, 400);


        /// Se incarca regele Arthur
        levelBuilder.addPlayer((PlayerEntity) entityFactory.createEntity("Arthur", sprites), 200, 300);

        /// Se incarca piratul
        levelBuilder.addEnemy((PlayerEntity) entityFactory.createEntity("Pirate", sprites), 600, 200);

        /// Se construieste nivelul folosind level builder
        level = levelBuilder.buildLevel();
        /// Crearea unui key handler
        keyHandler = new KeyHandler();
        /// Crearea unui player Act
        playerAct = new PlayerAct(new PlayerActImplementor(level.GetUser(), level.GetEnemy(), arthur_sheet, level.GetBackground(), level.GetItems(), level.GetCoins(), level.GetFires()));
        /// Se incarca keyListener
        wnd.GetFrame().addKeyListener(keyHandler);
    }
    public void Update() throws Exception {
        playerAct.execute(keyHandler.GetKeys());
        /// Actualizeaza monezile
        level.UpdateCoins(playerAct.GetCoins());
        /// Actualizeaza animatia cu foc
        level.updateAnimations(sprites);
        /// Actualizeaza scorul
        scoreBoard.updateScore(level.GetUser().getScore());
        /// Actualizeaza starea jocului
        if(level.GetUser().getHealth() == 0) {
            game.state = game.menuState;
            game.state.initState(game.getWnd());
        }
        /// Actualizeaza starea in caz de ESC
        if(keyHandler.GetKeys().contains(KeyEvent.VK_ESCAPE)) {
            game.state = game.menuState;
            game.state.initState(game.getWnd());
        }
        /// Actualizeaza starea in caz de coliziune cu inamicul
        /// Verificare atac inamic
        if(EnemyManager.checkCollision(level.GetUser(), level.GetEnemy())) {
            game.state = game.menuState;
            game.state.initState(game.getWnd());
            /// Efect sonor
            WinnerMusic winnerMusic = new WinnerMusic();
            winnerMusic.getSoundEffect();

            if(game.sessionInfo == null) {
                SQLGetData sqlGetData = new SQLGetData();
                sqlGetData.connect();
                game.sessionInfo = sqlGetData.getData(game.getUsername());
                sqlGetData.disconnect();
            }

            game.sessionInfo.updateBestScore(Math.max(game.sessionInfo.getBestScore(), level.GetUser().getScore()));
            game.sessionInfo.updateTotalScore(game.sessionInfo.getTotalScore() + level.GetUser().getScore());

            /// Se adauga scorul si timpul petrecut in joc
            SQLUpdateData sqlUpdateData = new SQLUpdateData();
            sqlUpdateData.connect();
            sqlUpdateData.updateData(game.getUsername(), game.sessionInfo.getLevel(), game.sessionInfo.getTimePlayed(), game.sessionInfo.getBestScore(), game.sessionInfo.getTotalScore());
        }
    }
    public void Draw(Graphics g) throws DrawingException {
        /// Se deseneaza harta
        level.drawObjects(g);
        /// Se deseneaza scoreboard
        scoreBoard.draw(g);
        /// Se deseneaza healthbar
        level.GetUser().updateHealthBar(g);
    }

}
