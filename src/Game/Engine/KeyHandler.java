package Game.Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler implements KeyListener {
    private final Set<Integer> keys = new HashSet<>();      /// container pentru a stoca tastele apasate
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        keys.add(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e) {
        keys.remove(e.getKeyCode());
    }
    public Set<Integer> GetKeys() {
        return this.keys;
    }
}
