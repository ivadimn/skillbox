public class Loader {
    public static void main(String[] args) {
        Double d1 = 24.0 * 0.1;
        System.out.println(d1);
        double d2 = 34.0 * 0.1;
        System.out.println(d2);
        System.out.println("Byte " + Byte.MIN_VALUE + " - " + Byte.MAX_VALUE);
        System.out.println("Short " + Short.MIN_VALUE + " - " + Short.MAX_VALUE);
        System.out.println("Int " + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE);
        System.out.println("Long " + Long.MIN_VALUE + " - " + Long.MAX_VALUE);
        System.out.println("Float " + Float.MIN_VALUE + " - " + Float.MAX_VALUE);
        System.out.println("Double " + Double.MIN_VALUE + " - " + Double.MAX_VALUE);
    }
}