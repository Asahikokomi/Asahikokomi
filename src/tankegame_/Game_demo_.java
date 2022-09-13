package tankegame_;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Asahi
 * @JDK 8
 */
@SuppressWarnings({"all"})
/**
 * 游戏进行区(相当于屏幕)
 */
public class Game_demo_ extends JFrame {
    private mypanel_ mt = null;
    static Scanner scanner = new Scanner(System.in);
    public Game_demo_() {
        System.out.println("请输入选择 1: 新游戏 2: 继续上局");
        String key = scanner.next();
        mt = new mypanel_(key);
        this.add(mt);
        new Thread(mt).start();
        this.setSize(1400, 800);
        this.addKeyListener(mt);//JFrame 监听键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder_ Recorder_ = new Recorder_();
                Recorder_.keepRecorder();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
            new Game_demo_();
    }
}
