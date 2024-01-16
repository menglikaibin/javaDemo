/**
 * @author 吴凯斌
 * 创建时间 2024/1/16 14:57
 */
public interface Info<T> {

    public T getVar();

}

class InfoImpl<T> implements Info<T> {

    private T var;

    public InfoImpl(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}

class Demo {
    public static void main(String[] args) {
        Info<String> i = null;
        i = new InfoImpl<String>("aa");

        Info<Integer> integerInfo = new InfoImpl<>(1);
        System.out.println("数字" + integerInfo.getVar());

        System.out.println("内容" + i.getVar());
    }
}

