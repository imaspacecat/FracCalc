import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoMuchPain {
    private static String frac = "1_3/2 + 55_6/5 * 5 - 1/2 + 68/7 - 3_5/4 / 3_5/6";
    private static Pattern p;
    private static Matcher m;
    private static Scanner s;
    public static void main(String[] args) {
        System.out.println(format("93897/322"));
        // input
        s = new Scanner(System.in);
        System.out.println("Enter a series of fractions: ");
        frac = s.nextLine();
        frac = " " + frac + " ";

        // convert whole numbers to fractions
        p = Pattern.compile("(\\d+_\\d+\\/\\d+)");
        m = p.matcher(frac);
        while(m.find()){
            frac = frac.replaceFirst(m.group(1), convertToFrac(m.group(1)));
        }

        p = Pattern.compile("( \\d+ )");
        m = p.matcher(frac);
        while(m.find()){
            frac = frac.replace(m.group(1), " " + m.group(1).strip() + "/1 ");
        }

        // solve * and /
        p = Pattern.compile("(\\d+\\/\\d+) (\\*|\\/) (\\d+\\/\\d+)");
        m = p.matcher(frac);
        while(m.find()){
            frac = frac.replace(m.group(1) + " " +  m.group(2) + " " + m.group(3),
                    op(m.group(1), m.group(3), m.group(2).charAt(0)));
        }

        // solve - and +
        p = Pattern.compile("(\\d+\\/\\d+) (\\+|\\-) (\\d+\\/\\d+)");
        m = p.matcher(frac);
        while(m.find()){
            frac = frac.replace(m.group(1) + " " +  m.group(2) + " " + m.group(3),
                    op(m.group(1), m.group(3), m.group(2).charAt(0)));
            m = p.matcher(frac);
        }
        System.out.println("Solution: " + format(frac.strip()));

    }

    // converts fractions with whole numbers to only fractions
    public static String convertToFrac(String s){
        int whole = Integer.parseInt(s.substring(0, s.indexOf('_')));
        int num = Integer.parseInt(s.substring(s.indexOf('_') + 1, s.indexOf('/')));
        int den = Integer.parseInt(s.substring(s.indexOf('/') + 1));
        int nNum = num + den * whole;
        return nNum + "/" + den;
    }

    // calculates specified operation between two string fractions
    public static String op(String frac1, String frac2, char op){
        int nume1 = Integer.parseInt(frac1.substring(0, frac1.indexOf('/')));
        int den1 = Integer.parseInt(frac1.substring(frac1.indexOf('/')+1));
        int nume2 = Integer.parseInt(frac2.substring(0, frac2.indexOf('/')));
        int den2 = Integer.parseInt(frac2.substring(frac2.indexOf('/')+1));

        int den = den1 * den2;
        int nume;
        if(op == '+') {
            nume = nume1 * den2 + nume2 * den1;
        } else if(op == '-'){
            nume = nume1 * den2 - nume2 * den1;
        } else if(op == '*'){
            nume = nume1 * nume2;
        } else {
            nume = nume1 * den2;
            den = den1 * nume2;
        }

        return asFraction(nume, den);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static String asFraction(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }

    private static String format(String input){
        if(!input.contains("/")) return input;

        int num = Integer.parseInt(input.substring(0, input.indexOf("/")));
        int den = Integer.parseInt(input.substring(input.indexOf("/")+1));

        if(den == 1) return String.valueOf(num);
        if(Math.abs(num)<Math.abs(den)) return num + "/" + den;
        return num/den+"_" + Math.abs(num%den) + "/" + den;

    }
}