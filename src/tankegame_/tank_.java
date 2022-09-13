package tankegame_;

import java.io.Serializable;

/**
 * @author Asahi
 * @JDK 17.0
 */
@SuppressWarnings({"all"})
/**
 * tank_为原始父类
 */
public class tank_ implements Serializable {
    private int dir;

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    private int x;
    private int y;
    private int speed = 1;//速度默认为 1

    private int harm;//炮弹伤害

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUP() {
        if (y > 0)
            y -= speed;
    }

    public void moveDOWN() {
        if (y + 60 < 720)
            y += speed;
    }

    public void moveLIFT() {
        if (x > 0)
            x -= speed;
    }

    public void moveRIGHT() {
        if (x + 60 < 1000)
            x += speed;
    }

    public tank_(int x, int y) {
        this.x = x;
        this.y = y;
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
}
