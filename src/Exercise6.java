import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().trim();

        if(isQuadraticEquation(userInput)){
            int firstNumber = getA(userInput);
            int secondNumber = getB(userInput);
            int thirdNumber = getC(userInput);
            solveQuadraticEquation(firstNumber,secondNumber,thirdNumber);
        }
    }

    public static void solveQuadraticEquation(int firstParameter, int secondParameter, int thirdParameter){
        double firstAnswer, secondAnswer;
        double quadEquationPart = Math.sqrt(secondParameter * secondParameter - 4 * firstParameter * thirdParameter);
        firstAnswer = (-secondParameter + quadEquationPart)/2*firstParameter;
        secondAnswer = (-secondParameter - quadEquationPart)/2*firstParameter;

        if(quadEquationPart >= 0){
            if(firstAnswer != secondAnswer) {
                System.out.println("Solved! There are 2 answers: x1 = " + firstAnswer + " x2 = " + secondAnswer);
            }else{
                System.out.println("Solved! There is one answer: x1 = " + firstAnswer);
            }
        }else {
            System.out.println("Unfortunately, there is no answer!");
        }
    }

    public static int getSignWhenNoNumber(char c){
        int result = 1;
        if(c == '-'){
            result = -1;
        }
        return result;
    }

    public static int getA(String equation){
        int a;
        if (equation.startsWith("x") || equation.startsWith("-x")) {
            a = getSignWhenNoNumber(equation.charAt(0));
        }else{
            a = Integer.parseInt(equation.substring(0,equation.indexOf("x")));
        }
        return a;
    }

    public static int getB(String equation){
        int b;
        equation = equation.substring(equation.indexOf("x^2")+3).trim();
        equation = equation.replaceAll(" ", "");
        if (equation.startsWith("+x") || equation.startsWith("-x")) {
            b = getSignWhenNoNumber(equation.charAt(0));
        }else{
            b = Integer.parseInt(equation.substring(0,equation.indexOf("x")));
        }
        return b;
    }

    public static int getC(String equation){
        int c;
        equation = equation.substring(equation.lastIndexOf("x")+1, equation.indexOf("=")).trim();
        equation = equation.replaceAll(" ", "");
        c = Integer.parseInt(equation);
        return c;
    }

    public static boolean isNumber(char toCheck){
        boolean isNum = false;
        for (int j = 0; j < 10; j++) {
            if ((toCheck + "").equals(j + "")) {
                isNum = true;
                break;
            }
        }
        return isNum;
    }

    public static boolean isQuadraticEquation(String userInput){
        boolean result = false;
        boolean firstPart = false;
        boolean secondPart = false;

        if(userInput.contains("x^2")) {
            if(userInput.charAt(0) == '-'){
                userInput = userInput.substring(1);
            }
            if (userInput.indexOf("x^2") != 0) {
                for(int i = 0; i < userInput.indexOf("x^2"); i++) {
                    firstPart = isNumber(userInput.charAt(i));
                    if (!firstPart) {
                        break;
                    }
                }
            }else{
                firstPart = true;
            }
        }

        if(firstPart){
            userInput = userInput.substring(userInput.indexOf("x^2") + 3).trim();
            if(userInput.length() > 1) {
                if (userInput.charAt(0) == '+' || userInput.charAt(0) == '-') {
                    userInput = userInput.substring(1).trim();
                    if (userInput.contains("x")) {
                        if(userInput.indexOf("x") != 0) {
                            for (int i = 0; i < userInput.indexOf("x"); i++) {
                                secondPart = isNumber(userInput.charAt(i));
                                if (!secondPart) {
                                    break;
                                }
                            }
                        }else{
                            secondPart = true;
                        }
                    }
                }
            }
        }
        if(secondPart){
            userInput = userInput.substring(userInput.indexOf("x") + 1).trim();
            if(userInput.length() > 1){
                if (userInput.charAt(0) == '+' || userInput.charAt(0) == '-') {
                    if(userInput.endsWith("0") && userInput.contains("=")){
                        userInput = userInput.substring(1,userInput.length()-1).trim();
                        if(userInput.endsWith("=")) {
                            userInput = userInput.replaceFirst("=","");
                            for (int i = 0; i < userInput.trim().length(); i++) {
                                result = isNumber(userInput.charAt(i));
                                if (!result) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
