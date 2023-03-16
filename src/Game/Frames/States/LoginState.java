package Game.Frames.States;

import Game.Database.SQLConnection;
import Game.Frames.FrameFinitState;
import Game.Game;
import Game.GameWindow.GameWindow;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginState extends FrameFinitState {
    Game game;
    public LoginState(Game game) {
        this.game = game;
    }
    @Override
    public void initState(GameWindow wnd) throws Exception {

    }

    @Override
    public void Update() throws Exception {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        System.out.print("Introduceti numele: ");
        String name = reader.readLine();
        SQLConnection sqlConnection = new SQLConnection();
        sqlConnection.connect();
        sqlConnection.insert("INSERT OR IGNORE INTO Users(" +
                "Name,Level,TimePlayed,BestScore,TotalScore)" +
                "VALUES ('" + name + "',1, 0, 0, 0);");
        game.setUsername(name);
        game.state = game.menuState;
        game.menuState.initState(game.getWnd());
    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(new Color(100, 100, 100));
        g.drawRect(0, 0, 900, 600);
        g.fillRect(0, 0, 900, 600);

        Font myFont1 = new Font("Montserrat Black", Font.BOLD, 80);
        g.setColor(new Color(255, 255, 255));
        g.setFont(myFont1);
        g.drawString("Login page ", 220, 200);
    }
}
