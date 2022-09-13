package tankegame_;

import java.io.Serializable;

/**
 * @author Asahi
 * @JDK 17.0
 */
@SuppressWarnings({"all"})
public class shot_ implements Runnable, Serializable {//炮弹类 一个线程
    private int x;//子弹x坐标
    private int y;//子弹y坐标
    private int dir;//子弹方向
    private int speed = 3;//子弹速度
    private boolean loop = true;

    public void moveUP() {
        y -= speed;
    }

    public void moveDOWN() {
        y += speed;
    }

    public void moveLIFT() {
        x -= speed;
    }

    public void moveRIGHT() {
        x += speed;
    }

    public shot_(int x, int y, int dir) {//构造器
        switch (dir) {
            case 0:
                this.x = x + 19;
                this.y = y - 12;
                this.dir = dir;
                break;
            case 1:
                this.x = x + 19;
                this.y = y + 70;
                this.dir = dir;
                break;
            case 2:
                this.x = x - 12;
                this.y = y + 19;
                this.dir = dir;
                break;
            case 3:
                this.x = x + 70;
                this.y = y + 19;
                this.dir = dir;
                break;
        }
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void BooLean() {//判断子弹位置是否合理
        if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 720)) {
            setLoop(false);
            return;
        }
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (dir) {
                case 0:
                    BooLean();
                    moveUP();
                    break;
                case 1:
                    BooLean();
                    moveDOWN();
                    break;
                case 2:
                    BooLean();
                    moveLIFT();
                    break;
                case 3:
                    BooLean();
                    moveRIGHT();
                    break;
            }
        }
    }
}
