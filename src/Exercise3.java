public class Exercise3 {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 1, 8, 9, 0, 2, 1, 3, 8, 0};
        removeDublicates(array);
    }

    public static void removeDublicates(int[] array) {
        int[] newArray = new int[array.length];
        int j = 0;
        int count=0;

        for (int i = 0; i < array.length-1; i++) {
            boolean check = false;

            if (array[i] != array[i + 1]) {

                if (i>0) {
                    for (int k = 0; k < i; k++) {
                        if (array[i] == array[k]) {
                            check = true;
                            count++;
                            break;
                        }
                    }
                }

                if (check == false) {
                    newArray[j++] = array[i];
                }
            }
        }


        for (int i = 0; i < newArray.length-count; i++) {
            System.out.print(newArray[i] + ",");
        }
    }
}
