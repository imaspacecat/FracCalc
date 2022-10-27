public class Testing {
    public static void main(String[] args) {
        String frac = "1_3/2 + 55_6/5 * 5 - 1/2 + 68/7 - 3_5/4";
        frac = frac.replaceAll("(_[1-9/ ]*)|(-|\\+|\\*|\\/) (\\d+[^_]\\d)", " ")
                .strip().replaceAll(" +", " ");
        System.out.println(frac);
//        String frac1 = frac.substring(0, frac.indexOf(' '));
//        String frac2 = frac.substring(frac.indexOf('+')+2);
//        System.out.println(frac1 + frac2);
    }
}
