/**
 * @author 吴凯斌
 * 创建时间 2024/1/16 20:33
 */
public class InfoDemo<T extends Number> {

    private T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    @Override
    public String toString() {
        return this.var.toString();
    }
}

class DemoAA {
    public static void main(String[] args) {
        InfoDemo<Integer> demo = new InfoDemo<>();
        demo.setVar(100);

        System.out.println(demo.getVar().toString());
    }
}
