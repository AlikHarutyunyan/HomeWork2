import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        int[] arr = {1,-4,7,1,8,-9,2,1,3,8,0};
        System.out.println(Arrays.toString(removeDuplicates(arr)));
    }
    public static int[] removeDuplicates(int[] arr) {
        String arrString = "";
        for (int i = 0; i < arr.length; i++) {
            if(!(arrString.contains(String.valueOf(arr[i])))){
                arrString += arr[i] + ",";
            }
        }
        String[] stringArr = arrString.split(",");
        int[] returnArray = new int[stringArr.length];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = Integer.parseInt(stringArr[i]);
        }
        return returnArray;
    }
}
