package Practic;

public class Samsung_First_TZ {
    public static void main(String[] args) {
        Solution test = new Solution();
        String key= new String("BALLOON");
        String s1 = new String("BAONXXOLL");
        String s2 = new String("BAOOLLNNOLOLGBAX");
        String s3 = new String("QAWABAWONL");
        String s4 = new String("ONLABLABLOON");

        System.out.println(s4);
        System.out.println(test.solution(s4, key));
    }
}

class Solution {
    public int solution (String s, String key){
        int countIteration = 0;
        StringBuffer sBuffer = new StringBuffer(s);
        String[][] uniqueKeyLetterArray = toUniqueWordArray(key);
        while (findWord(sBuffer, uniqueKeyLetterArray)) {
            minusKey(sBuffer, uniqueKeyLetterArray);
            System.out.println(sBuffer);
            countIteration++;
        }
        return countIteration;
    }

    boolean findWord(StringBuffer s, String[][] keyUnique){
        for (int i=0;i<keyUnique.length;i++) {
            int counterLetter = 0;
            for (int j=0;j<s.length();j++) {
                if (keyUnique[i][0].equals(Character.toString(s.charAt(j)))) {
                    counterLetter++;
                }
            }
            if (Integer.parseInt(keyUnique[i][1])>counterLetter){
                return false;
            }
        }
        return true;
    }

    void minusKey(StringBuffer s, String[][] stringArray){
        for (int i=0;i<stringArray.length;i++){
            for (int j=0;j<Integer.parseInt(stringArray[i][1]);j++){
                for (int l=0;l<s.length();l++){
                    if (stringArray[i][0].equals(Character.toString(s.charAt(l)))){
                        s.deleteCharAt(l);
                        break;
                    }
                }
            }
        }
    }

    String[][] toUniqueWordArray(String key){
        String[][] keyArray = convertToArray(key);
        for (int i=0;i<keyArray.length-2;i++){
            for (int j=i+1;j<keyArray.length-1;j++){
                if (keyArray[i][0].equals(keyArray[j][0])){
                    keyArray[i][1]=Integer.toString(Integer.parseInt(keyArray[i][1])*-1);
                }
            }
        }
        int counterLengthUniqueElement = 0;
        for (int i=0;i<keyArray.length;i++){
            if (Integer.parseInt(keyArray[i][1])>0){
                counterLengthUniqueElement++;
            }
        }
        String[][] result = new String[counterLengthUniqueElement][2];
        int step = 0;
        for (int i=0;i<keyArray.length;i++){
            if (Integer.parseInt(keyArray[i][1])>0){
                result[step] = keyArray[i];
                step++;
            }
        }
        return result;
    }

    String[][] convertToArray(String key){
        String[][] result = new String[key.length()][2];
        for (int i=0;i<key.length();i++){
            result[i][0]=Character.toString(key.charAt(i));
        }
        for (int i=0;i<result.length;i++){
            int counter = 0;
            for (int j=0;j<result.length;j++){
                if (result[i][0].equals(result[j][0])){
                    counter++;
                }
            }
            result[i][1]=Integer.toString(counter);
        }
        return result;
    }
}
