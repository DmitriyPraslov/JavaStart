package Practic;

public class StringPlusIntagerOne {
    public static void main(String[] args) {
        String someString = "12345678901234567846";
        int someIntager = 1;
        System.out.println(stringPlusIntager(someString, someIntager));
    }

    public static String stringPlusIntager(String line, int digit){
        String result = "";
        int[] parsIntFromStringArray = new int[line.length()];
        String temp;
        for (int i=0;i<line.length();i++){
            temp = Character.toString(line.charAt(i));
            parsIntFromStringArray[i] = Integer.parseInt(temp);
        }
        int positionToInsertDigit = findPositionToInsert(parsIntFromStringArray);
        parsIntFromStringArray[positionToInsertDigit]=parsIntFromStringArray[positionToInsertDigit]+digit;
        for (int i=positionToInsertDigit+1;i<parsIntFromStringArray.length;i++){
            parsIntFromStringArray[i]=0;
        }
        return convertIntArrayToString(parsIntFromStringArray);
    }

    public static int findPositionToInsert(int[] arr) {
        int result = arr.length-1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 9) {
                result = i-1;
            } else {
                break;
            }
        }
        return result;
    }

    public static String convertIntArrayToString(int[] arr){
        StringBuffer result = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            result.append(arr[i]);
        }
        return result.toString();
    }
}
