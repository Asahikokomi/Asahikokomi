package tankegame_;

/**
 * @author Asahi
 * @JDK 17.0
 * 用于判断是否击中
 */
@SuppressWarnings({"all"})
public class hit_ {
    public static void AI(shot_ shot, tankai_ tankai_) {
        switch (tankai_.getDir()) {
            case 0:
            case 1:
                if ((shot.getX() > tankai_.getX() && shot.getX() < tankai_.getX() + 40)
                        && (shot.getY() > tankai_.getY() && shot.getY() < tankai_.getY() + 60)) {
                    shot.setLoop(false);
                    tankai_.setLife(false);
                    bomb bomb = new bomb(tankai_.getX(), tankai_.getY());
                    mypanel_.bombs.add(bomb);
                    Recorder_.addNum();
                }
                break;
            case 2:
            case 3:
                if (shot.getX() > tankai_.getX() && shot.getX() < tankai_.getX() + 60 &&
                        shot.getY() > tankai_.getY() && shot.getY() < tankai_.getY() + 40) {
                    shot.setLoop(false);
                    tankai_.setLife(false);
                    bomb bomb = new bomb(tankai_.getX(), tankai_.getY());
                    mypanel_.bombs.add(bomb);
                    Recorder_.addNum();
                }
                break;
        }
    }

    public static void Player(shot_ shot, mytank_ mytank) {
        switch (mytank.getDir()) {
            case 0:
            case 1:
                if ((shot.getX() > mytank.getX() && shot.getX() < mytank.getX() + 40)
                        && (shot.getY() > mytank.getY() && shot.getY() < mytank.getY() + 60)) {
                    shot.setLoop(false);
                    mytank.setLife(false);
                    bomb bomb = new bomb(mytank.getX(), mytank.getY());
                    mypanel_.bombs.add(bomb);
                }
                break;
            case 2:
            case 3:
                if (shot.getX() > mytank.getX() && shot.getX() < mytank.getX() + 60 &&
                        shot.getY() > mytank.getY() && shot.getY() < mytank.getY() + 40) {
                    shot.setLoop(false);
                    mytank.setLife(false);
                    bomb bomb = new bomb(mytank.getX(), mytank.getY());
                    mypanel_.bombs.add(bomb);
                }
                break;
        }

    }
}
