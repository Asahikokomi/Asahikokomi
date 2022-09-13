package tankegame_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author Asahi
 * @JDK 8
 */
@SuppressWarnings({"all"})
/**
 * 设计框
 */
public class mypanel_ extends JPanel implements KeyListener, Runnable {
    Vector<mytank_> mt = new Vector<>();
    static int num = 3;//每位玩家的坦克个数

    public static void setNum(int num) {
        mypanel_.num = num;
    }

    //mytank_ mt = null;
    Vector<tankai_> ais = new Vector<>();//AI坦克集合

    public static int getNum() {
        return num;
    }

    public Vector<tankai_> getAis() {
        return ais;
    }

    public void setAis(Vector<tankai_> ais) {
        this.ais = ais;
    }

    public static Vector<bomb> getBombs() {
        return bombs;
    }

    public static void setBombs(Vector<bomb> bombs) {
        mypanel_.bombs = bombs;
    }

    static Vector<bomb> bombs = new Vector<>();//爆炸效果集合
    private int SIZE = 3;//AI个数
    //定义三张图片,用于显示效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public mypanel_(String key) {//构造器
        File file = new File(Recorder_.getOtherpath());
        if (!file.exists()) {
            System.out.println("文件数据不存在!");
            key = "1";
        }
        switch (key) {
            case "2":
                Recorder_ recorder_ = new Recorder_();
                recorder_.ReadInfo();
                recorder_.ReadAinum();
                num = Recorder_.copynum;
                SIZE = Recorder_.aInum;
                mt = Recorder_.mytank_a;
                for (int k = 0; k < mt.size(); k++) {
                    mytank_ mytank_ = mt.get(k);
                    if (mytank_.isLife()) {
                        for (int j = 0; j < mytank_.shot_s.size(); j++) {
                            new Thread(mytank_.shot_s.get(j)).start();
                        }
                    }
                }
                ais = Recorder_.tankai_a;
                for (int i = 0; i < ais.size(); i++) {//继续让AI坦克自由行动
                    tankai_ tankai_ = ais.get(i);
                    new Thread(tankai_).start();
                    for (int j = 0; j < tankai_.shots.size(); j++) {
                        new Thread(tankai_.shots.get(j)).start();
                    }
                }
                break;
            case "1":
                File file1 = new File(Recorder_.getPath());
                if (file1.exists()) {
                    Recorder_ recorder_1 = new Recorder_();
                    recorder_1.ReadAinum();
                }
                for (int i = 0; i < num; i++) {
                    mytank_ mytank_ = new mytank_(500, 500);
                    mytank_.setSpeed(10);
                    mt.add(mytank_);
                }
                for (int i = 0; i < SIZE; i++) {//初始化AI坦克
                    tankai_ tankai_ = new tankai_(100 * (i + 1), 0);
                    ais.add(tankai_);
                    tankai_.setTankai_s(ais);
                    new Thread(tankai_).start();
//            shot_ shot_ = new shot_(tankai_.getX(), tankai_.getY(), tankai_.getDir());
//            tankai_.shots.add(shot_);
//            new Thread(shot_).start();
                }
                break;
            default:
                System.out.println("输入错误!");
        }
        Recorder_.copynum = num;
        Recorder_.tankai_a = ais;
        Recorder_.mytank_a = mt;
        Recorder_.aInum = SIZE;
        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(mypanel_.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(mypanel_.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(mypanel_.class.getResource("/bomb_3.gif"));
        //添加音乐
        //new AePlayWave("src\\BGM.wav").start();//播放音乐
    }

    //画出玩家击杀数
    private void showkill(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("微软雅黑", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("玩家累计击毁敌方坦克", 1050, 25);
        make_.AI(1050, 80, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder_.getNum() + "", 1100, 120);
    }

    //游戏其他信息
    private void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("微软雅黑", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("当前游戏信息", 1115, 200);
        g.drawString("敌人坦克剩余", 1010, 280);
        make_.AI(1200, 240, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(ais.size() + "", 1260, 280);
        g.drawString("玩家坦克剩余", 1010, 380);
        make_.Player(1200, 340, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(num + "", 1260, 380);
    }

    @Override
    public void paint(Graphics g) {//画板和画笔
        super.paint(g);
        g.fillRect(0, 0, 1000, 720);
        if (num != 0) {
            mytank_ mt_ = mt.get(num - 1);
            if (mt_ != null && mt_.isLife()) {
                make_.Player(mt_.getX(), mt_.getY(), g, mt_.getDir(), 1);
            } else {
                //mt.remove(mt_);
                num--;
            }//玩家
            for (int i = 0; i < mt_.shot_s.size(); i++) {
                shot_ shot_ = mt_.shot_s.get(i);
                if (!(shot_ == null) && shot_.getLoop() == true) {//玩家炮弹
                    make_.cannonball(shot_.getX(), shot_.getY(), g, shot_.getDir(), 1);
                } else {
                    mt_.shot_s.remove(shot_);
                }
            }
        }
        for (int i = 0; i < bombs.size(); i++) {
            bomb bomb = bombs.get(i);
            if (bomb.getLife() > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.isIslife() == false) {
                bombs.remove(bomb);
            }
        }
        for (int i = 0; i < ais.size(); i++) {
            tankai_ tankai_ = ais.get(i);
            if (tankai_.isLife()) {
                make_.AI(tankai_.getX(), tankai_.getY(), g, tankai_.getDir(), 1);
            } else {
                ais.remove(tankai_);
            }
            for (int j = 0; j < tankai_.shots.size(); j++) {
                shot_ shot_ = tankai_.shots.get(j);
                if (shot_.getLoop()) {
                    make_.cannonballAI(shot_.getX(), shot_.getY(), g, shot_.getDir(), 1);
                } else {
                    tankai_.shots.remove(j);
                }
            }
//            for (int j = 0; j < tankai_.shots.size(); j++) {
//
//            }
        }
        showInfo(g);
        showkill(g);
        //make_.AI(mt.getX(), mt.getY(), g, mt.getDir(), 1);
    }

    /**
     * 监听键盘输入事件
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        class MOVE implements Runnable {
            @Override
            public void run() {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W://坦克向上移动
                        mt.get(num - 1).setDir(0);
                        if (!anti_.ai(mt.get(num - 1), ais)) {
                            mt.get(num - 1).moveUP();
                        }
                        break;
                    case KeyEvent.VK_S://坦克向下移动
                        mt.get(num - 1).setDir(1);
                        if (!anti_.ai(mt.get(num - 1), ais)) {
                            mt.get(num - 1).moveDOWN();
                        }
                        break;
                    case KeyEvent.VK_A://坦克向左移动
                        mt.get(num - 1).setDir(2);
                        if (!anti_.ai(mt.get(num - 1), ais)) {
                            mt.get(num - 1).moveLIFT();
                        }
                        break;
                    case KeyEvent.VK_D://坦克向右移动
                        mt.get(num - 1).setDir(3);
                        if (!anti_.ai(mt.get(num - 1), ais)) {
                            mt.get(num - 1).moveRIGHT();
                        }
                        break;
                }
            }
        }
        class attack implements Runnable {

            @Override
            public void run() {
                if (e.getKeyCode() == KeyEvent.VK_J) {
                    if (num != 0)
                        mt.get(num - 1).FillShot_();
                }
            }
        }
        MOVE move = new MOVE();
        new Thread(move).start();
        attack attack = new attack();
        new Thread(attack).start();
    }

    private void Boolean_P() {
        Iterator<tankai_> iterator = ais.iterator();
        for (tankai_ ai : ais) {
            for (int i = 0; i < ai.shots.size(); i++) {
                shot_ shot_ = ai.shots.get(i);
                if (shot_ != null && shot_.getLoop()) {
                    if (num != 0)
                        hit_.Player(shot_, mt.get(num - 1));
                }
            }
        }
    }

    private void Boolean_M() {//封装
        if (num != 0) {
            for (int i = 0; i < mt.get(num - 1).shot_s.size(); i++) {
                shot_ shot_ = mt.get(num - 1).shot_s.get(i);
                if (shot_ != null && shot_.getLoop()) {
                    for (int j = 0; j < ais.size(); j++) {
                        tankai_ tankai_ = ais.get(j);
                        hit_.AI(shot_, tankai_);
                    }
                }
            }
        }
    }

//    private static void AIshot_() {
//        for (int i = 0; i < ais.size(); i++) {
//            tankai_ tankai_ = ais.get(i);
//            if (tankai_.isLife() && tankai_.shots.size() == 0) {
//                shot_ shot_ = new shot_(tankai_.getX(), tankai_.getY(), tankai_.getDir());
//                tankai_.shots.add(shot_);
//                new Thread(shot_).start();
//            }
//        }
//    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//mypanel线程 不断重绘刷新
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Boolean_M();
            Boolean_P();
            this.repaint();
        }
    }
}
