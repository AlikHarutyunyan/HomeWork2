import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your quadratic equation: ");
        userInput = scanner.nextLine();
        System.out.println(isQuadraticEquation(userInput));
    }

    public static boolean isQuadraticEquation (String userInput) {
        boolean firstPart = false;
        boolean secondPart = false;
        boolean result = false;

        if (userInput.contains("x^2")) {
            if (userInput.charAt(0)=='-') {
                userInput = userInput.substring(1);
            }
            if (userInput.indexOf("x^2")!=0) {
                for (int j = 0; j < userInput.indexOf("x^2"); j++) {
                    for (int k = 0; k < 10; k++) {
                        if (("" + userInput.charAt(j)).equals("" + k)) {
                            firstPart = true;
                            break;
                        }

                        else {
                            firstPart = false;
                        }
                    }

                    if (!firstPart) {
                        break;
                    }
                }
            }

            else {
                firstPart=true;
            }

        }

        if (firstPart) {
            userInput=userInput.substring(userInput.indexOf("x^2")+3);

            if (userInput.charAt(0) == '+' || userInput.charAt(0) == '-') {
                userInput = userInput.substring(1);
                if (userInput.contains("x")) {
                    if (userInput.indexOf("x")!=0) {
                        for (int i = 0; i < userInput.indexOf("x"); i++) {
                            for (int j = 0; j < 10; j++) {
                                if (("" + userInput.charAt(i)).equals("" + j)) {
                                    secondPart = true;
                                    break;
                                }

                                else {
                                    secondPart = false;
                                }
                            }

                            if (!secondPart) {
                                break;
                            }
                        }
                    }

                    else {
                        secondPart = true;
                    }
                }
            }
        }

        if (secondPart) {
            userInput = userInput.substring(userInput.indexOf("x")+1);
            if (userInput.charAt(0) == '+' || userInput.charAt(0) == '-') {
                userInput = userInput.substring(1);

                if (userInput.endsWith("=0")) {
                    for (int i = 0; i < userInput.indexOf("=0"); i++) {
                        for (int j = 0; j < 10; j++) {

                            if (("" + userInput.charAt(i)).equals("" + j)) {
                                result = true;
                                break;
                            }

                            else {
                                result = false;
                            }
                        }

                        if (!result) {
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
