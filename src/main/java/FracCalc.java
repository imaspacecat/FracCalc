import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        System.out.println(op("1/2", "3/4", '+'));
        System.out.println(op("1/2", "3/4", '-'));
        System.out.println(op("1/2", "3/4", '*'));
        System.out.println(op("1/2", "3/4", '/'));

        String testFrac = "1_1/2 + 3_5/4";
        System.out.println("whole sum: " + wholeOp(testFrac, 6, '+'));

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
                        System.out.println(wholeOp(fracS, i, '*'));
//                        for (int k = fracS.indexOf('*'); k > 0; k--) {
//                            if(fracS.charAt(k) == ' '){
//                                if(whitespaces == 1){
//                                    whitepos = k;
//                                }
//                                whitespaces++;
//                            }
//                            if(whitespaces == 2) {
//                                if (fracS.charAt(k) == '_') {
//                                    whole1 = Integer.parseInt(fracS.substring(whitepos, k));
//                                }
//                            }
//                        }
//
//                        for (int k = fracS.indexOf('*'); k < fracS.length(); k++) {
//                            if (fracS.charAt(k) == '_') {
//                                whole2 = Integer.parseInt(fracS.substring(fracS.indexOf('*')+1, k));
//                            }
//                        }

                    } else if(fracS.charAt(i) == ' ' && fracS.charAt(i + 1) == '/'){

                    } else if(fracS.charAt(i) == '+'){
                        System.out.println(wholeOp(fracS, i, '+'));
                    } else {
                        System.out.println(wholeOp(fracS, i, '-'));
                    }

                }

            }
        }




    }

    // basic operations with fractions
    public static String op(String frac1, String frac2, char op){
        int nume1 = Integer.parseInt(frac1.substring(0, 1));
        int den1 = Integer.parseInt(frac1.substring(2));
        int nume2 = Integer.parseInt(frac2.substring(0, 1));
        int den2 = Integer.parseInt(frac2.substring(2));

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

    public static int wholeOp(String frac, int opIndex, char op){
        int whole1 = 0;
        int whole2 = 0;
        int whitespaces = 0;
        int whitepos = 0;
        frac = " " + frac + " ";
        System.out.println(frac);
        for (int k = opIndex; k >= 0; k--) {
            System.out.println("char: " + frac.charAt(k));
            if(frac.charAt(k) == ' '){
                if(whitespaces == 1){
                    whitepos = k;
                }
                whitespaces++;
            }

            if (frac.charAt(k) == '_') {
                System.out.println("ere");
                if (whitespaces == 2) {
                    System.out.println("sub1: " + frac.substring(whitepos, k));
                    whole1 = Integer.parseInt(frac.substring(whitepos, k));

                }
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
//     for(int i = 0; i < fracS.length(); i++) {
//
//
////            if(fracS.charAt(i) == '+' || fracS.charAt(i) == '-' ||
////                    fracS.charAt(i) == '*' || fracS.charAt(i) == '/'){
////                operatorI = i;
////            }
////
////            if(fracS.charAt(i) == '_'){
////                if(whole1 == -1){
////                    whole1 = i;
////                } else{
////                    whole2 = i;
////                }
////            }
////
////            if(fracS.charAt(i) == ' '){
////                if(white1 == -1){
////                    white1 = i;
////                } else{
////                    white2 = i;
////                }
////            }
//        }
////        String frac1 = fracS.substring(operatorI+1).strip();
////        String frac2 = fracS.substring(0, operatorI).strip();
////        System.out.println(fracS.substring(0, whole1) + " " + fracS.substring(white2, whole2));
////        int whole1Num = Integer.parseInt(fracS.substring(0, whole1).strip());
////        int whole2Num = Integer.parseInt(fracS.substring(white2, whole2).strip());
////        System.out.println(frac1 + " " + frac2);
////        System.out.println("wholes are " + whole1Num + " " + whole2Num);
//
//
//
//
}
