public class HelloByte {
    public static void main(String[] args) {
        int b = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                b = b + i;
            }
        }
        System.out.println(b);
    }
}
