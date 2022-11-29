import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        int randomNumber = randomNumber();
        playGame(randomNumber);
    }

    public static int randomNumber () {
        int randomNumber;
        Random random = new Random();
        String result = "";

        do {
            randomNumber = random.nextInt(1,6);
            if (!(result.contains("" +randomNumber))) {
                result += randomNumber;
            }
        } while (result.length()<4);

        randomNumber = Integer.parseInt(result);
        return randomNumber;
    }

    public static void playGame (int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        int codeToGuess;
        boolean continuePlaying = true;
        System.out.println("Guess the secret code: ");
        int numberOfRoute = chooseDifficulty();
        int maxTries = calculateTries(numberOfRoute);

        do {

            if (maxTries > 0) {
                if (numberOfRoute != 4) {
                    System.out.println("you have " + maxTries + " tries left");
                } else {
                    System.out.println("you have surprise tries left");
                }

                codeToGuess = scanner.nextInt();

                if (hasDublicates(codeToGuess)) {
                    System.out.println("you got fined by 2 tries");
                    maxTries-=2;
                }

                if (String.valueOf(codeToGuess).length() == 4) {
                    if (randomNumber == codeToGuess) {
                        System.out.println("Congratulations! you won the game");
                        continuePlaying = false;
                    } else {
                        getHint(codeToGuess, randomNumber);
                    }
                }
            }

            else {
                System.out.println("you dont have any tries left");
                continuePlaying=false;
            }

            maxTries--;
        }while (continuePlaying);
    }


    public static void getHint (int codeToGuess, int randomNumber) {
        String codeToGuessString = "" + codeToGuess;
        String randomNumberString = "" + randomNumber;

        for (int i=0; i<codeToGuessString.length(); i++) {
            if (randomNumberString.contains("" + codeToGuessString.charAt(i))) {
                if (randomNumberString.charAt(i)==codeToGuessString.charAt(i)) {
                    System.out.println(codeToGuessString.charAt(i) + " is in correct position");
                }

                else {
                    System.out.println(codeToGuessString.charAt(i) + " exist but in different position");
                }
            }
        }
    }

    public static int chooseDifficulty() {
        Scanner scanner = new Scanner(System.in);

        int userInput;
        boolean endLoop = false;

        do {
            System.out.println("choose the the route:");
            System.out.println("1. easy route - 20 tries");
            System.out.println("2. medium route - 15 tries");
            System.out.println("3. hard route - 10 tries");
            System.out.println("4. surprise route - 5-25 tries");
            userInput = scanner.nextInt();

            if (userInput>=1 && userInput<=4) {
                endLoop=true;
            }

        } while (!endLoop);

        return userInput;
    }

    public static int calculateTries (int userInput) {
        int tries;

        if (userInput == 1) {
            tries = 20;
        }

        else if (userInput == 2) {
            tries = 15;
        }

        else if (userInput == 3) {
            tries = 10;
        }

        else {
            Random random = new Random();
            tries = random.nextInt(5,25);
        }
        return tries;
    }

    public static boolean hasDublicates(int codeToGuess) {
        boolean hasDuplicates = false;
        String codeToGuessString = codeToGuess + "";

        for (int i = 0; i<codeToGuessString.length(); i++) {
            for (int j = i+1; j < codeToGuessString.length(); j++) {
                if (codeToGuessString.charAt(i)==codeToGuessString.charAt(j)) {
                    hasDuplicates = true;
                }
            }
        }
        return hasDuplicates;
    }
}

