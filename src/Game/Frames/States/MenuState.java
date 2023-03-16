package Game.Frames.States;

import Game.Engine.KeyHandler;
import Game.Frames.FrameFinitState;
import Game.Game;
import Game.GameWindow.GameWindow;
import Game.Graphics.ImageLoader;
import Game.Objects.Background;
import Game.Utilities.Polygon;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class MenuState extends FrameFinitState {
    private Game game;
    private Background background;
    private KeyHandler mouseHandler;
    public MenuState(Game game) {
        this.game = game;
        /// Creare key handler
        mouseHandler = new KeyHandler();
    }
    @Override
    public void initState(GameWindow wnd) throws Exception {
        this.background = new Background(ImageLoader.LoadImage("/Images/background/menu_bg.png"), 900, 600, new Polygon());
        wnd.GetFrame().addKeyListener(mouseHandler);
    }
    @Override
    public void Update() throws Exception {
        Set<Integer> keys = mouseHandler.GetKeys();
        /// Actualizez starea in functie de tasta apasata
        if(keys != null) {
            if(keys.contains(KeyEvent.VK_Z)){
                game.state = game.levelState;
                game.state.initState(game.getWnd());
            } else if(keys.contains(KeyEvent.VK_X)) {
                game.state = game.statsState;
                game.state.initState(game.getWnd());
            }  else if(keys.contains(KeyEvent.VK_C)) {
                game.state = game.helpState;
                game.state.initState(game.getWnd());
            } else if(keys.contains(KeyEvent.VK_Q)) {
                game.StopGame();
                System.exit(0);
            }
        }
    }
    @Override
    public void Draw(Graphics g) {
        this.background.Draw(g);
    }
}
