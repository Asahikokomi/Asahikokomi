package tankegame_;

import java.util.Vector;

/**
 * @author Asahi
 * @JDK 8
 */
@SuppressWarnings({"all"})
/**
 * 玩家可以自定义自己的坦克属性，继承父类tank_
 */
public class mytank_ extends tank_ {
    private boolean life = true;//生命

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    //private int dir;//坦克的方向
    Vector<shot_> shot_s = new Vector<>();
//    shot_ shot = null;

    public mytank_(int x, int y) {
        super(x, y);
        setDir(0);
    }

    public void FillShot_() {
        if (shot_s.size() == 5) {
            return;
        }
        shot_ shot = new shot_(getX(), getY(), getDir());
        shot_s.add(shot);
        new Thread(shot).start();
    }
}
