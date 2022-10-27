public class Testing {
    public static void main(String[] args) {
        String frac = " 3332_1/2 + 413_5/4 ";
        frac = frac.replaceAll("( [1-9]*_)", " ").strip();
        System.out.println(frac);
        String frac1 = frac.substring(0, frac.indexOf(' '));
        String frac2 = frac.substring(frac.indexOf('+')+2);
        System.out.println(frac1 + frac2);
    }
}
