public class Exercise4 {
    public static void main(String[] args) {
        int[] array = {1,3,6,11,10,9,4,2,0};
        System.out.println(checkRiseAndFall(array));
    }

    public static int checkRiseAndFall (int[] array) {
        int maxNumberIndex=0;
        int max = array[0];
        boolean fallCheck=true;
        boolean riseCheck=true;
        int status = -1;

        for (int i=0; i<array.length; i++) { //find the max
            if (array[i]>max) {
                max=array[i];
                maxNumberIndex = i;
            }
        }

        for (int i = maxNumberIndex; i < array.length-1; i++) { //check the fall
            if (array[i]<array[i+1]) {
                fallCheck = false;
                break;
            }
        }

        for (int i = maxNumberIndex; i > 0 ; i--) { //check the rise
            if (array[i]<array[i-1]) {
                riseCheck = false;
                break;
            }
        }

        if (fallCheck && riseCheck) {
            status = maxNumberIndex;
        }

        return status;
    }
}
