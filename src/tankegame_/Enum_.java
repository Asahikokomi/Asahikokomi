package tankegame_;

/**
 * @author Asahi
 * @JDK 17.0
 */
@SuppressWarnings({"all"})
/**
 * 枚举类，目前未进行使用(原设计用于判断坦克方向的enum类)
 */
public enum Enum_ {
    MOVEW("W"),MOVEA("A"),MOVES("S"),MOVED("D");
    private String dir;
    Enum_(String w) {
        this.dir = w;
    }
}
