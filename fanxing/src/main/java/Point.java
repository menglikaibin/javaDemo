/**
 * @author 吴凯斌
 * 创建时间 2024/1/16 14:54
 */
class Point<T> {

    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}

class GenericsDemo {
    public static void main(String[] args) {
        Point<String> point = new Point<>();
        point.setVar("aa");
        System.out.println(point.getVar());
    }
}
