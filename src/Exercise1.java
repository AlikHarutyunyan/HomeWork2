import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        biggerThanAverage();
    }

    public static void biggerThanAverage() {
        Scanner scanner = new Scanner(System.in);
        final int MAX_NUMBERS=10;
        int number;
        double average;
        int sum=0;

        int[] array = new int[MAX_NUMBERS];

        for (int i = 0; i < MAX_NUMBERS; i++) {
            System.out.println("Enter a number: ");
            number = scanner.nextInt();
            array[i]=number;
            sum+=number;
        }

        average = (double)sum/MAX_NUMBERS;

        for (int i = 0; i < MAX_NUMBERS; i++) {
            if (array[i]>average) {
                System.out.println(array[i]);
            }
        }
    }
}