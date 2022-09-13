package tankegame_;

import java.awt.*;

/**
 * @author Asahi
 * @JDK 17.0
 */
@SuppressWarnings({"all"})
/**
 * 创建坦克(可通过方向进行创建)
 */
public class make_ {

    /**
     * @param x         坦克的x坐标
     * @param y         坦克的y坐标
     * @param g         画笔
     * @param direction 坦克的方向
     * @param type      坦克的类型或者炮弹类型
     */
    public static void Player(int x, int y, Graphics g, int direction, int type) {

        g.setColor(Color.PINK);
        switch (direction) {
            case 0://上
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 18, y - 10, 4, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                break;
            case 1://下
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 18, y + 30, 4, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                break;
            case 2://左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x - 10, y + 18, 40, 4, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                break;
            case 3://右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x + 30, y + 18, 40, 4, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                break;

        }
    }

    public static void AI(int x, int y, Graphics gAI, int direction, int type) {
        gAI.setColor(Color.CYAN);
        switch (direction) {
            case 0://上
                gAI.fill3DRect(x, y, 10, 60, false);
                gAI.fill3DRect(x + 30, y, 10, 60, false);
                gAI.fill3DRect(x + 10, y + 10, 20, 40, false);
                gAI.fill3DRect(x + 18, y - 10, 4, 40, false);
                gAI.fillOval(x + 10, y + 20, 20, 20);
                break;
            case 1://下
                gAI.fill3DRect(x, y, 10, 60, false);
                gAI.fill3DRect(x + 30, y, 10, 60, false);
                gAI.fill3DRect(x + 10, y + 10, 20, 40, false);
                gAI.fill3DRect(x + 18, y + 40, 4, 40, false);
                gAI.fillOval(x + 10, y + 20, 20, 20);
                break;
            case 2://左
                gAI.fill3DRect(x, y, 60, 10, false);
                gAI.fill3DRect(x, y + 30, 60, 10, false);
                gAI.fill3DRect(x + 10, y + 10, 40, 20, false);
                gAI.fill3DRect(x - 10, y + 18, 40, 4, false);
                gAI.fillOval(x + 20, y + 10, 20, 20);
                break;
            case 3://右
                gAI.fill3DRect(x, y, 60, 10, false);
                gAI.fill3DRect(x, y + 30, 60, 10, false);
                gAI.fill3DRect(x + 10, y + 10, 40, 20, false);
                gAI.fill3DRect(x + 30, y + 18, 40, 4, false);
                gAI.fillOval(x + 20, y + 10, 20, 20);
                break;

        }
    }

    public static void cannonball(int x, int y, Graphics g, int direction, int type) {//画炮弹
        g.setColor(Color.PINK);
        switch (direction) {
            case 0://上
                g.draw3DRect(x, y, 2, 2, false);
                break;
            case 1://下
                g.draw3DRect(x, y, 2, 2, false);
                break;
            case 2://左
                g.draw3DRect(x, y, 2, 2, false);
                break;
            case 3://右
                g.draw3DRect(x, y, 2, 2, false);
                break;

        }
    }

    public static void cannonballAI(int x, int y, Graphics gAI, int direction, int type) {
        gAI.setColor(Color.CYAN);
        switch (direction) {
            case 0://上
                gAI.draw3DRect(x, y, 2, 2, false);
                break;
            case 1://下
                gAI.draw3DRect(x, y, 2, 2, false);
                break;
            case 2://左
                gAI.draw3DRect(x, y, 2, 2, false);
                break;
            case 3://右
                gAI.draw3DRect(x, y, 2, 2, false);
                break;

        }
    }
}
