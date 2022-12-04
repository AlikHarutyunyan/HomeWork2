import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your quadratic equation: ");
        userInput = scanner.nextLine();
        System.out.println(isQuadraticEquation(userInput));
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
