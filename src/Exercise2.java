import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write an Israeli phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println(formatNumber(phoneNumber));
    }

    public static String formatNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        if(checkIfNumber(phoneNumber)) {
            boolean formatIsAcceptable = false;
            final int DIGITS_QUANTITY = 11;

            if (phoneNumber.startsWith("9725")) {
                if (!(phoneNumber.contains("-"))) {
                    phoneNumber = "0" + phoneNumber.substring(3);
                }
            }

            if (phoneNumber.startsWith("05")) {
                if (!phoneNumber.contains("-") && phoneNumber.length() == DIGITS_QUANTITY-1) {
                    formatIsAcceptable = true;
                    String code = phoneNumber.substring(0, 3);
                    phoneNumber = code + phoneNumber.replaceFirst(code, "-");
                } else if (phoneNumber.charAt(3) == '-' && phoneNumber.length() == DIGITS_QUANTITY) {
                    if(!phoneNumber.substring(4).contains("-")){
                        formatIsAcceptable = true;
                    }
                }
            }
            if (!formatIsAcceptable) {
                phoneNumber = "";
            }
        }else{
             phoneNumber = "";
        }
        return phoneNumber;
    }

    public static boolean checkIfNumber(String phoneNumber){
        boolean isNumber = false;
        boolean conditionIsMet;
        for (int i = 0; i < phoneNumber.length(); i++) {
            conditionIsMet = false;
            for (int j = 0; j < 10; j++) {
                if(("" + phoneNumber.charAt(i)).equals("" + j) || phoneNumber.charAt(i) == '-'){
                    conditionIsMet = true;
                    break;
                }
            }
            if(!conditionIsMet){
                break;
            }
            if(i == phoneNumber.length()-1){
                isNumber = true;
            }
        }
        return isNumber;
    }
}