import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoMuchPain {
    private static String frac = "1_3/2 + 55_6/5 * 5 - 1/2 + 68/7 - 3_5/4";
    // 5/2 + 281/5 * 5 - 1/2 + 68/7 - 17/4
    private static Pattern p;
    private static Matcher m;
    public static void main(String[] args) {
        // (\d+_\d+\/\d+)
        // (\d+\/\d+) \* (\d+\/\d+)
        p = Pattern.compile("(\\d+_\\d+\\/\\d+)");
        m = p.matcher(frac);

        while(m.find()){
            frac = frac.replaceFirst(m.group(1), convertToPartialFrac(m.group(1)));
        }
        p = Pattern.compile("( \\d )");
        m = p.matcher(frac);
        while(m.find()){
            frac = frac.replace(m.group(1), " " + m.group(1) + "/1" + " ");
            System.out.println(m.group(1));
        }
        System.out.println(frac);


    }

    public static String convertToPartialFrac(String s){
        int whole = Integer.parseInt(s.substring(0, s.indexOf('_')));
        int num = Integer.parseInt(s.substring(s.indexOf('_') + 1, s.indexOf('/')));
        int den = Integer.parseInt(s.substring(s.indexOf('/') + 1));
        int nNum = num + den * whole;
        return nNum + "/" + den;
    }
}
