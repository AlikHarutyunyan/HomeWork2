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
                result = result.concat("" + randomNumber);
            }
        } while (result.length()<4);

        randomNumber = Integer.parseInt(result);
        return randomNumber;
    }

    public static void playGame (int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        int codeToGuess;
        boolean continuePlaying = true;
        System.out.println("LET'S PLAY 'GUESS THE SECRET CODE' You need to guess 4 numbers from 1 to 6 (NO DUPLICATES!)");
        int numberOfRoute = chooseDifficulty();
        int maxTries = calculateTries(numberOfRoute);

        do {
            if (maxTries > 0) {
                if (numberOfRoute != 4) {
                    System.out.println("You have " + maxTries + " tries left");
                }else {
                    System.out.println("You have SURPRISE tries left");
                }

                codeToGuess = scanner.nextInt();

                if (hasDuplicates(codeToGuess)) {
                    System.out.println("!!! YOU GOT FINED BY 2 POINTS, DON'T REPEAT NUMBERS !!!");
                    maxTries-=2;
                }

                if (String.valueOf(codeToGuess).length() == 4) {
                    if (randomNumber == codeToGuess) {
                        System.out.println("Congratulations! You won the game");
                        continuePlaying = false;
                    }else {
                        getHint(codeToGuess, randomNumber);
                    }
                }
            }else {
                System.out.println("!!!GAME OVER!!! You dont have any tries left");
                continuePlaying=false;
            }
            maxTries--;
        }while (continuePlaying);
    }


    public static void getHint (int codeToGuess, int randomNumber) {
        String codeToGuessString = "" + codeToGuess;
        String randomNumberString = "" + randomNumber;

        System.out.println("------------------------------------");
        for (int i=0; i<codeToGuessString.length(); i++) {
            if (randomNumberString.contains("" + codeToGuessString.charAt(i))) {
                if (randomNumberString.charAt(i)==codeToGuessString.charAt(i)) {
                    System.out.println(codeToGuessString.charAt(i) + " is in correct position");
                }else {
                    System.out.println(codeToGuessString.charAt(i) + " exist but in different position");
                }
            }
        }
        System.out.println("------------------------------------");
    }

    public static int chooseDifficulty() {
        Scanner scanner = new Scanner(System.in);

        int userInput;
        boolean endLoop = false;

        do {
            System.out.println("Choose the the route:");
            System.out.println("1. Easy route - 20 tries");
            System.out.println("2. Medium route - 15 tries");
            System.out.println("3. Hard route - 10 tries");
            System.out.println("4. Surprise route - 5-25 tries");
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
        }else if (userInput == 2) {
            tries = 15;
        }else if (userInput == 3) {
            tries = 10;
        }else {
            Random random = new Random();
            tries = random.nextInt(5,25);
        }
        return tries;
    }

    public static boolean hasDuplicates(int codeToGuess) {
        boolean hasDuplicates = false;
        String codeToGuessString = codeToGuess + "";

        for (int i = 0; i<codeToGuessString.length(); i++) {
            for (int j = i+1; j < codeToGuessString.length(); j++) {
                if (codeToGuessString.charAt(i)==codeToGuessString.charAt(j)) {
                    hasDuplicates = true;
                    break;
                }
            }
        }
        return hasDuplicates;
    }
}

