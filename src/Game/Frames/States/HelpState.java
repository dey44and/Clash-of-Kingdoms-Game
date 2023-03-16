package Game.Frames.States;

import Game.Engine.KeyHandler;
import Game.Frames.FrameFinitState;
import Game.Game;
import Game.GameWindow.GameWindow;
import Game.Graphics.ImageLoader;
import Game.Objects.Background;
import Game.Utilities.Polygon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class HelpState extends FrameFinitState {
    private Game game;
    private Background background;
    private KeyHandler keyHandler;
    public HelpState(Game game) {
        this.game = game;
        /// Creare key handler
        keyHandler = new KeyHandler();
    }
    @Override
    public void initState(GameWindow wnd) throws Exception {
        this.background = new Background(ImageLoader.LoadImage("/Images/background/help_bg.png"), 900, 600, new Polygon());
        wnd.GetFrame().addKeyListener(keyHandler);
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
    }
}
