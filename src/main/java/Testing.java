public class Testing {
    public static void main(String[] args) {
        String frac = "1_3/2 + 55_6/5 * 5 - 1/2 + 68/7 - 3_5/4";
        frac = frac.replaceAll("(_[1-9/ ]*)|(-|\\+|\\*|\\/) (\\d+[^_]\\d)", " ")
                .strip().replaceAll(" +", " ");
        System.out.println(frac);
//        String frac1 = frac.substring(0, frac.indexOf(' '));
//        String frac2 = frac.substring(frac.indexOf('+')+2);
//        System.out.println(frac1 + frac2);

        /*
        while (infix has characters left to process)
{
nextCharacter = next nonblank character of infix
switch (nextCharacter)
{
case variable:
valueStack.push(value of the variable nextCharacter)
break
case '^' :
operatorStack.push(nextCharacter)
break
case '+' : case '-' : case '*' : case '/' :
while (!operatorStack.isEmpty() and precedence of nextCharacter <= precedence of
{
// Execute operator at top of operatorStack
topOperator = operatorStack.pop()
operandTwo = valueStack.pop()
operandOne = valueStack.pop()
result = the result of the operation in topOperator and its operands valueStack.push(result)
}
operatorStack.push(nextCharacter)
break
case '(' :
operatorStack.push(nextCharacter)
break
case ')' : // Stack is not empty if infix expression is valid
topOperator = operatorStack.pop()
while (topOperator != '(')
{
operandTwo = valueStack.pop()
operandOne = valueStack.pop()
result = the result of the operation in topOperator and its operands
operandOne and operandTwo
valueStack.push(result)
topOperator = operatorStack.pop()
}
break
default: break // Ignore unexpected characters
}
}
while (!operatorStack.isEmpty())
{
topOperator = operatorStack.pop()
operandTwo = valueStack.pop()
operandOne = valueStack.pop()
result = the result of the operation in topOperator and its operands
operandOne and operandTwo
valueStack.push(result)
}
return valueStack.peek()
         */
    }
}
