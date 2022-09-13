package tankegame_;

/**
 * @author Asahi
 * @JDK 17.0
 */
@SuppressWarnings({"all"})
public class bomb {
    private int x;
    private int y;
    private int life = 10;
    private boolean islife = true;

    public bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {
        if (life > 0)
            life--;
        else islife = false;
    }

    public boolean isIslife() {
        return islife;
    }

    public void setIslife(boolean islife) {
        this.islife = islife;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
