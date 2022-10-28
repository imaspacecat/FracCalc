public class Testing {
    public static void main(String[] args) {
        String frac = "1_3/2 + 55_6/5 * 5 - 1/2 + 68/7 - 3_5/4";
        String whole = frac.replaceAll("(_[1-9/ ]*)|(-|\\+|\\*|\\/) (\\d+[^_]\\d)", " ")
                .strip().replaceAll(" +", " ");
        System.out.println(whole);
        String temp = "";

        int sum = 0;
        // (\d+ (\*|\/) \d)
        for (int i = 0; i < whole.length(); i++) {
            char c = whole.charAt(i);
            if(c == '*' || c == '/'){

                whole = whole.replaceFirst("(\\d+ (\\*|\\/) \\d)", "");
                System.out.println("temp is: " + temp);
                sum += addString(temp, c);
            }
        }


    }

    public static int addString(String a, char op){
        int n1 = Integer.parseInt(a.substring(0, a.indexOf(op)-1));
        int n2 = Integer.parseInt(a.substring(a.indexOf(op)+2));
        if(op == '+') return n1 + n2;
        if(op == '-') return n1 - n2;
        if(op == '*') return n1 * n2;
        if(op == '/') return n1 / n2;
        return -1;
    }
}
