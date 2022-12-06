import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        char[] board = {'1','2','3','4','5','6','7','8','9'};
        printBoard(board);
        char symbol = 'o';
        int position;
        int count = 0;

        do {

            if (count==9) {
                System.out.println("No winner");
                break;
            }

            if (symbol=='x') {
                symbol = 'o';
            }

            else {
                symbol = 'x';
            }

            System.out.println("It's player-" + symbol + " turn");
            position = getPositionFromUser(board);
            count++;



        } while (!placeSymbolOnBoard(board,position,symbol));
    }

    public static void printBoard (char[] board) {
        for (int i = 1; i <= board.length; i++) {
            System.out.print(board[i-1] + "\t");

            if (i%3==0) {
                System.out.println();
            }
        }
    }

    public static boolean isAvailable (char[] board, int place) {
        return board[place - 1] != 'x' && board[place - 1] != 'o';
    }

    public static int getPositionFromUser (char[] board) {
        Scanner scanner = new Scanner(System.in);
        int position;
        boolean endLoop = false;
        System.out.println("Enter the position: ");

        do {
            position = scanner.nextInt();
            if (position>=1 && position<=9) {
                if (isAvailable(board,position)) {
                    endLoop = true;
                }

                else {
                    System.out.println("The position is already taken");
                }
            }

            else {
                System.out.println("Write a number between one and nine");
            }
        } while (!endLoop);
        return position;
    }

    public static char checkWinner (char[] board) {
        int [][] winningScenarios = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};

        String xPositions="";
        String oPositions="";
        char winner = '-';

        for (int i = 1; i <= board.length; i++) {
            if (board[i-1]=='x') {
                xPositions += i;
            }

            else if (board[i-1]=='o'){
                oPositions += i;
            }
        }
        int countO = 0;
        int countX = 0;


        for (int i = 0; i < winningScenarios.length; i++) {
            for (int j = 0; j < winningScenarios[i].length; j++) {
                if (xPositions.contains(winningScenarios[i][j]+"")) {
                    countX++;
                }

                else if (oPositions.contains(winningScenarios[i][j]+"")) {
                    countO++;
                }
            }

            if (countX==3) {
                winner = 'x';
                break;
            }

            else if (countO==3) {
                winner = 'o';
                break;
            }

            else {
                countO=0;
                countX=0;
            }
        }
        return winner;
    }

    public static boolean placeSymbolOnBoard (char[] board, int place, char symbol) {
        board[place-1]=symbol;
        printBoard(board);
        boolean hasWinner = true;

        if (checkWinner(board)=='x') {
            System.out.println("Player X won the game");
        }

        else if (checkWinner(board)=='o') {
            System.out.println("Player O won the game");
        }

        else {
            hasWinner = false;
        }
       return hasWinner;
    }
}
