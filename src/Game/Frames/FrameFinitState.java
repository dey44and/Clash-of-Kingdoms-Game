package Game.Frames;

import Game.Exceptions.DrawingException;
import Game.GameWindow.GameWindow;
import java.awt.*;

public abstract class FrameFinitState {
    abstract public void initState(GameWindow wnd) throws Exception;
    abstract public void Update() throws Exception;
    abstract public void Draw(Graphics g) throws DrawingException;
}