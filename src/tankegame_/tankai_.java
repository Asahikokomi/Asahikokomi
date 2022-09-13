package tankegame_;

import java.io.Serializable;
import java.util.Vector;

/**
 * @author Asahi
 * @JDK 8
 */
@SuppressWarnings({"all"})
/**
 * AI 可以自定义 AI坦克的属性(自定义难度，增加游戏乐趣)
 */
public class tankai_ extends tank_ implements Runnable {
    private int count = 1;//发射炮弹数量(根据难度)
    private boolean life = true;
    private boolean aBoolean = true;

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    //private int dir = 1;
    Vector<shot_> shots = new Vector<>();

    public tankai_(int x, int y) {
        super(x, y);
        setDir(1);
    }

    public void judge() {
        if (!(this.getX() > 0 && this.getX() < 1000 && this.getY() > 0 && this.getY() < 720)) {
            aBoolean = false;
        } else aBoolean = true;
        return;
    }

    Vector<tankai_> tankai_s = new Vector<>();

    public void setTankai_s(Vector<tankai_> tankai_s) {
        this.tankai_s = tankai_s;
    }

//    public boolean isanti() {//防止ai坦克互相碰撞
//
//        //判断当前敌人坦克(this) 方向
//        switch (this.getDir()) {
//            case 0: //上
//                //让当前敌人坦克和其它所有的敌人坦克比较
//                for (int i = 0; i < tankai_s.size(); i++) {
//                    //从vector 中取出一个敌人坦克
//                    tankai_ tankai_ = tankai_s.get(i);
//                    //不和自己比较
//                    if (tankai_ != this) {
//                        //如果敌人坦克是上/下
//                        if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 40
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                            if (this.getX() + 40 >= tankai_.getX()
//                                    && this.getX() + 40 <= tankai_.getX() + 40
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                        }
//                        //如果敌人坦克是 右/左
//                        if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 60
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                            if (this.getX() + 40 >= tankai_.getX()
//                                    && this.getX() + 40 <= tankai_.getX() + 60
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                        }
//                    }
//
//                }
//                break;
//            case 1: //下
//                //让当前敌人坦克和其它所有的敌人坦克比较
//                for (int i = 0; i < tankai_s.size(); i++) {
//                    //从vector 中取出一个敌人坦克
//                    tankai_ tankai_ = tankai_s.get(i);
//                    //不和自己比较
//                    if (tankai_ != this) {
//                        //如果敌人坦克是上/下
//                        if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 40
//                                    && this.getY() + 60 >= tankai_.getY()
//                                    && this.getY() + 60 <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                            if (this.getX() + 40 >= tankai_.getX()
//                                    && this.getX() + 40 <= tankai_.getX() + 40
//                                    && this.getY() + 60 >= tankai_.getY()
//                                    && this.getY() + 60 <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                        }
//                        //如果敌人坦克是 右/左
//                        if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 60
//                                    && this.getY() + 60 >= tankai_.getY()
//                                    && this.getY() + 60 <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                            if (this.getX() + 40 >= tankai_.getX()
//                                    && this.getX() + 40 <= tankai_.getX() + 60
//                                    && this.getY() + 60 >= tankai_.getY()
//                                    && this.getY() + 60 <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//                break;
//            case 2: //左
//                //让当前敌人坦克和其它所有的敌人坦克比较
//                for (int i = 0; i < tankai_s.size(); i++) {
//                    //从vector 中取出一个敌人坦克
//                    tankai_ tankai_ = tankai_s.get(i);
//                    //不和自己比较
//                    if (tankai_ != this) {
//                        //如果敌人坦克是上/下
//                        if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 40
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 40
//                                    && this.getY() + 40 >= tankai_.getY()
//                                    && this.getY() + 40 <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                        }
//                        //如果敌人坦克是 右/左
//                        if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 60
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                            if (this.getX() >= tankai_.getX()
//                                    && this.getX() <= tankai_.getX() + 60
//                                    && this.getY() + 40 >= tankai_.getY()
//                                    && this.getY() + 40 <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//                break;
//            case 3: //右
//                //让当前敌人坦克和其它所有的敌人坦克比较
//                for (int i = 0; i < tankai_s.size(); i++) {
//                    //从vector 中取出一个敌人坦克
//                    tankai_ tankai_ = tankai_s.get(i);
//                    //不和自己比较
//                    if (tankai_ != this) {
//                        //如果敌人坦克是上/下
//
//                        if (tankai_.getDir() == 0 || tankai_.getDir() == 1) {
//                            if (this.getX() + 60 >= tankai_.getX()
//                                    && this.getX() + 60 <= tankai_.getX() + 40
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                            if (this.getX() + 60 >= tankai_.getX()
//                                    && this.getX() + 60 <= tankai_.getX() + 40
//                                    && this.getY() + 40 >= tankai_.getY()
//                                    && this.getY() + 40 <= tankai_.getY() + 60) {
//                                return true;
//                            }
//                        }
//                        //如果敌人坦克是 右/左
//                        if (tankai_.getDir() == 2 || tankai_.getDir() == 3) {
//                            if (this.getX() + 60 >= tankai_.getX()
//                                    && this.getX() + 60 <= tankai_.getX() + 60
//                                    && this.getY() >= tankai_.getY()
//                                    && this.getY() <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                            if (this.getX() + 60 >= tankai_.getX()
//                                    && this.getX() + 60 <= tankai_.getX() + 60
//                                    && this.getY() + 40 >= tankai_.getY()
//                                    && this.getY() + 40 <= tankai_.getY() + 40) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//                break;
//        }
//        return false;
//    }

//    public void shot_() {
//
//        if (isLife() && shots.size() < count) {
//            shot_ shot_ = new shot_(getX(), getY(), getDir());
//            shots.add(shot_);
//            new Thread(shot_).start();
//        }
//    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    class shot_ai implements Runnable, Serializable {//内部类(每个坦克单独的发射线程)

        @Override
        public void run() {
            while (life) {
                if (shots.size() < count) {
                    shot_ shot_ = new shot_(getX(), getY(), getDir());
                    shots.add(shot_);
                    new Thread(shot_).start();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void run() {//让AI能够自由移动
        shot_ai shot_ai = new shot_ai();
        new Thread(shot_ai).start();
        while (life) {
            switch (getDir()) {
                case 0:
                    int a = (int) (20 + Math.random() * (30 - 20 + 1));
                    for (int i = 0; i < a; i++) {
                        if (!anti_.ai(this, tankai_s)) {
                            moveUP();
                        } else {
                            aBoolean = false;
                            setDir(1);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        judge();
                        if (!aBoolean) {
                            setDir(1);
                            break;
                        }
                    }
                    break;
                case 1:
                    int b = (int) (20 + Math.random() * (30 - 20 + 1));
                    for (int i = 0; i < b; i++) {
                        if (!anti_.ai(this, tankai_s)) {
                            moveDOWN();
                        } else {
                            aBoolean = false;
                            setDir(0);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        judge();

                        if (!aBoolean) {
                            setDir(0);
                            break;
                        }
                    }
                    break;
                case 2:
                    int c = (int) (20 + Math.random() * (30 - 20 + 1));
                    for (int i = 0; i < c; i++) {
                        if (!anti_.ai(this, tankai_s)) {
                            moveLIFT();
                        } else {
                            aBoolean = false;
                            setDir(3);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        judge();
                        if (!aBoolean) {
                            setDir(3);
                            break;
                        }
                    }
                    break;
                case 3:
                    int d = (int) (20 + Math.random() * (30 - 20 + 1));
                    for (int i = 0; i < d; i++) {
                        if (!anti_.ai(this, tankai_s)) {
                            moveRIGHT();
                        } else {
                            aBoolean = false;
                            setDir(2);
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        judge();
                        if (!aBoolean) {
                            setDir(2);
                            break;
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!aBoolean) {
                continue;
            }
            setDir((int) (Math.random() * 4));
        }
    }
}
