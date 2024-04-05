package nested;

public class shadowingMain {

    public int value = 1;

    class Inner {
        public int value = 2;

        void go() {
            int value = 3;
            System.out.println("value = " + value);
            System.out.println("this.value = " + this.value);
            System.out.println("ShadowingMain.value = " + shadowingMain.this.value);
        }
    }

    public static void main(String[] args) {
        shadowingMain main = new shadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
