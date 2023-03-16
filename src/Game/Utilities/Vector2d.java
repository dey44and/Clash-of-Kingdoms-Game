package Game.Utilities;

public class Vector2d {
    private int x;
    private int y;
        /// Metode pentru a seta si a obtine pozitia pe axele de coordonate
    public Vector2d() {

    }
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void SetX(int x) {
        this.x = x;
    }
    public void SetY(int y) {
        this.y = y;
    }
    public int GetX() {
        return this.x;
    }
    public int GetY() {
        return this.y;
    }
    public void addVec(Vector2d v) {
        this.x += v.GetX();
        this.y += v.GetY();
    }
}
