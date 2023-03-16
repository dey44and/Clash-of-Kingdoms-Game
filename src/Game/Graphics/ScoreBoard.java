package Game.Graphics;

import java.awt.*;

public class ScoreBoard {
    int score;
    String[] fonts;
    public ScoreBoard() {
        GraphicsEnvironment GE;
        GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts = GE.getAvailableFontFamilyNames();
    }
    public void draw(Graphics g) {
        Font myFont = new Font("Montserrat Black", Font.BOLD, 30);
        g.setColor(new Color(80, 0, 0));
        g.setFont(myFont);
        g.drawString("Score: " + score, 750, 30);
    }
    public void updateScore(int score) {
        this.score = score;
    }
}
