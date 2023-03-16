package Game.Frames.States;

import Game.Database.SQLGetData;
import Game.Database.SessionInfo;
import Game.Engine.KeyHandler;
import Game.Frames.FrameFinitState;
import Game.Game;
import Game.GameWindow.GameWindow;
import Game.Graphics.ImageLoader;
import Game.Objects.Background;
import Game.Utilities.Polygon;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StatsState extends FrameFinitState {
    private Game game;
    private Background background;
    private KeyHandler keyHandler;

    public StatsState(Game game) {
        this.game = game;
        /// Creare key handler
        keyHandler = new KeyHandler();
    }
    @Override
    public void initState(GameWindow wnd) throws Exception {
        this.background = new Background(ImageLoader.LoadImage("/Images/background/stats_bg.png"), 900, 600, new Polygon());
        wnd.GetFrame().addKeyListener(keyHandler);
        SQLGetData sqlGetData = new SQLGetData();
        sqlGetData.connect();
        game.sessionInfo = sqlGetData.getData(game.getUsername());
    }

    @Override
    public void Update() throws Exception {
        /// Actualizeaza starea in caz de ESC
        if(keyHandler.GetKeys().contains(KeyEvent.VK_ESCAPE)) {
            game.state = game.menuState;
            game.state.initState(game.getWnd());
        }
    }

    @Override
    public void Draw(Graphics g) {
        this.background.Draw(g);
        Font myFont = new Font("Montserrat Black", Font.BOLD, 30);
        g.setColor(new Color(255, 255, 255));
        g.setFont(myFont);
        String content = "Name: " + this.game.sessionInfo.getName();
        g.drawString(content, 350, 280);
        content = "Level: " + this.game.sessionInfo.getLevel();
        g.drawString(content, 350, 320);
        content = "Time Played: " + this.game.sessionInfo.getTimePlayed();
        g.drawString(content, 350, 360);
        content = "Best score: " + this.game.sessionInfo.getBestScore();
        g.drawString(content, 350, 400);
        content = "Total score: " + this.game.sessionInfo.getTotalScore();
        g.drawString(content, 350, 440);
    }
}
