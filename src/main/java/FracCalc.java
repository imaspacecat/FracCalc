import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two fractions separated by a '+'");
        String fracS = scanner.nextLine();
        int operatorI = 0;
        boolean addition = false;
        boolean subtraction = false;
        int white1 = -1;
        int white2 = -1;
        int whole1 = -1;
        int whole2 = -1;
        for(int i = 0; i < fracS.length(); i++) {
            if(fracS.charAt(i) == '+' || fracS.charAt(i) == '-' ||
                    fracS.charAt(i) == '*' || fracS.charAt(i) == '/'){
                operatorI = i;
            }

            if(fracS.charAt(i) == '_'){
                if(whole1 == -1){
                    whole1 = i;
                } else{
                    whole2 = i;
                }
            }

            if(fracS.charAt(i) == ' '){
                if(white1 == -1){
                    white1 = i;
                } else{
                    white2 = i;
                }
            }
        }
        String frac1 = fracS.substring(operatorI+1).strip();
        String frac2 = fracS.substring(0, operatorI).strip();
        System.out.println(fracS.substring(0, whole1) + " " + fracS.substring(white2, whole2));
        int whole1Num = Integer.parseInt(fracS.substring(0, whole1).strip());
        int whole2Num = Integer.parseInt(fracS.substring(white2, whole2).strip());
        System.out.println(frac1 + " " + frac2);
        System.out.println("wholes are " + whole1Num + " " + whole2Num);




    }
}
