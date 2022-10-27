import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
//        System.out.println(op("11/2", "3/4", '+'));
//        System.out.println(op("1/2", "33/4", '-'));
//        System.out.println(op("1/2", "3/4", '*'));
//        System.out.println(op("1/2", "3/4", '/'));

        String testFrac = "3332_1/2 - 413_5/4";
        int testIndex = testFrac.indexOf('-');
//        System.out.println("whole sum: " + wholeOp(testFrac, testIndex, '-'));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two fractions separated by a '+'");
        String fracS = scanner.nextLine();
//        int operatorI = 0;
//        boolean addition = false;
//        boolean subtraction = false;
//        int white1 = -1;
//        int white2 = -1;
//        int whole1 = -1;
//        int whole2 = -1;

        int whole = 0;
        String frac = "";

        int ops = 0;
        // find number of operations
        for (int i = 0; i < fracS.length(); i++) {
            if(fracS.charAt(i) == '+' || fracS.charAt(i) == '-' ||
                    fracS.charAt(i) == '*' || fracS.charAt(i) == '/'){
                ops++;
            }
        }

//        int whole1;
//        int whole2;
//
//        int whitespaces = 0;
//        int whitepos = 0;
        for (int i = 0; i < ops; i++) {
            for (int j = 0; j < fracS.length(); j++) {
                if(i != fracS.length()-1) {
                    if (fracS.charAt(i) == '*'){
                        System.out.println(wholeOp(fracS, '*'));
                        System.out.println(op(frac, '*'));
                    } else if(fracS.charAt(i) == ' ' && fracS.charAt(i + 1) == '/'){
                        System.out.println(wholeOp(fracS, '/'));
                        System.out.println(op(frac, '/'));

                    } else if(fracS.charAt(i) == '+'){
                        System.out.println(wholeOp(fracS, '+'));
                        System.out.println(op(frac, '+'));
                    } else {
                        System.out.println(wholeOp(fracS, '-'));
                        System.out.println(op(frac, '-'));
                    }

                }

            }
        }




    }

    // basic operations with fractions
    public static String op(String frac, char op){

        frac = frac.replaceAll("( [1-9]*_)", " ").strip();
        System.out.println(frac);
        String frac1 = frac.substring(0, frac.indexOf(' '));
        String frac2 = frac.substring(frac.indexOf('+')+2);
        System.out.println(frac1 + frac2);

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
            // division
            nume = nume1 * den2;
            den = den1 * nume2;
        }

        //simplify
        while(nume % 2 == 0 && den % 2 == 0){
            nume /= 2;
            den /= 2;
        }

        return nume + "/" + den;
    }

    public static int wholeOp(String frac, char op){
        int opIndex = frac.indexOf(op);
        int whole1 = 0;
        int whole2 = 0;
        int whitespaces = 0;
        int whitepos = 0;
        int slashpos = 0;
        frac = " " + frac + " ";
        System.out.println(frac);
        for (int k = opIndex+1; k >= 0; k--) { // scuffed fix
            System.out.println("char: " + frac.charAt(k));
            if(frac.charAt(k) == ' '){
                System.out.println("space");
                if(whitespaces == 1){
                    whitepos = k;
                }
                whitespaces++;
            }
            if(frac.charAt(k) == '_'){
                slashpos = k;
            }

            if (whitespaces == 2) {
                System.out.println("sub1: " + frac.substring(whitepos, slashpos));
                whole1 = Integer.parseInt(frac.substring(whitepos, slashpos).strip());
            }
        }

        for (int k = opIndex; k < frac.length(); k++) {
            if (frac.charAt(k) == '_') {
                System.out.println("sub: " + frac.substring(frac.indexOf(op)+2, k));
                whole2 = Integer.parseInt(frac.substring(frac.indexOf(op)+2, k));
            }
        }

        if(op == '+') return whole1 + whole2;
        if(op == '-') return whole1 - whole2;
        if(op == '*') return whole1 * whole2;
        if(op == '/') return whole1 / whole2;
        return -1;
    }
}
