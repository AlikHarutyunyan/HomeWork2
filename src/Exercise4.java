public class Exercise4 {
    public static void main(String[] args) {
        int[] array = {5,3,2,1};
        System.out.println(checkRiseAndFall(array));
    }

    public static int checkRiseAndFall (int[] array) {
        int maxNumberIndex = 0;
        int max = array[0];
        boolean fallCheck = false;
        int status = -1;

        for (int i=1; i<array.length; i++) {
            if (array[i]>max) {
                max=array[i];
                maxNumberIndex = i;
            }

            else {
                break;
            }
        }

        if (maxNumberIndex>0 && maxNumberIndex<array.length-1) {
            for (int i = maxNumberIndex; i < array.length-1; i++) {
                if (array[i]<array[i+1]) {
                    fallCheck = false;
                    break;
                }

                else {
                    fallCheck = true;
                }
            }
        }


        if (fallCheck) {
            status = maxNumberIndex;
        }

        return status;
    }
}
