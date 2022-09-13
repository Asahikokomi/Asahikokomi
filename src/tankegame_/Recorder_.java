package tankegame_;

import java.io.*;
import java.util.Vector;

/**
 * @author Asahi
 * 记录玩家击杀数Object流
 */
@SuppressWarnings({"all"})
public class Recorder_ {
    //玩家累计击杀AI坦克个数
    private static int ainum = 0;

    //用静态copynum去获取玩家坦克数量
    public static int copynum = 0;

    //playernum用于序列化存储玩家坦克数量
    private int playernum = 0;

    public static int aInum = 0;
    private int aIint = 0;
    private static FileWriter fw = null;
    private static FileReader fr = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static ObjectOutputStream ot = null;
    private static ObjectInputStream oi = null;

    //保存累计击杀AI坦克个数路径
    private static String path = "src\\myrecorder.txt";

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Recorder_.path = path;
    }

    //保存上一局各方面数据路径
    private static String otherpath = "src\\data.dat";

    public static String getOtherpath() {
        return otherpath;
    }

    public static void setOtherpath(String otherpath) {
        Recorder_.otherpath = otherpath;
    }

    public static Vector<tankai_> tankai_a = new Vector<>();
    Vector<tankai_> tankai_s = new Vector<>();
    public static Vector<mytank_> mytank_a = new Vector<>();
    Vector<mytank_> mytank_s = new Vector<>();

    public Vector<tankai_> getTankai_s() {
        return tankai_s;
    }

    public void setTankai_s(Vector<tankai_> tankai_s) {
        this.tankai_s = tankai_s;
    }

    public Vector<mytank_> getMytank_s() {
        return mytank_s;
    }

    public void setMytank_s(Vector<mytank_> mytank_s) {
        this.mytank_s = mytank_s;
    }

    //游戏退出时就存盘
    public void keepRecorder() {
        try {
            playernum = copynum;
            aIint = aInum;
            setTankai_s(tankai_a);
            setMytank_s(mytank_a);
            ot = new ObjectOutputStream(new FileOutputStream(otherpath));
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            ot.writeInt(playernum);
            ot.writeInt(aIint);
            ot.writeObject(mytank_s);
            ot.writeObject(tankai_s);
            bw.write(getNum() + "");
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ot != null) {
                try {
                    ot.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //读取上一局游戏数据
    public void ReadInfo() {
        try {
            oi = new ObjectInputStream(new FileInputStream(otherpath));
            copynum = oi.readInt();
            aInum = oi.readInt();
            Object ob1 = oi.readObject();
            mytank_a = (Vector<mytank_>) ob1;
            Object ob2 = oi.readObject();
            tankai_a = (Vector<tankai_>) ob2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //读取玩家累计击杀的AI坦克个数
    public void ReadAinum() {
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String len = null;
            while ((len = br.readLine()) != null) {
                ainum = Integer.parseInt(len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static int getNum() {
        return ainum;
    }

    public static void setNum(int num) {
        Recorder_.ainum = num;
    }
    //如果玩家击杀一个AI坦克就调用一次此方法
    public static void addNum() {
        ainum += 1;
    }
}
