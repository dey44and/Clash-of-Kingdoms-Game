package Game;
public class Main {
    public static void main(String[] args) {
        // game = new Game("Clash of Kingdoms", 900, 600);
        Game game = Game.getInstance("Clash of Kingdoms", 900, 600);
        game.StartGame();
    }
}