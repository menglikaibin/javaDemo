/**
 * @author 吴凯斌
 * 创建时间 2024/1/16 14:52
 */
public class FanXing {

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a.doubleValue() + b.doubleValue());

        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        add(1, 9L);
    }
}
