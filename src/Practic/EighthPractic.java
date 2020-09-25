package Practic;

public class EighthPractic {
    public static void main(String[] args) {
        int[] mas1 = {2,7,3,8,3,6,2,9,5,4};
        countSameElement(mas1);
    }
    public static void countSameElement(int[] arr){
        int[] result = unicArray(arr);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]+"-"+countElement(arr, result[i])+" "+printCountLine(countElement(arr, result[i])));
        }
    }

    public static int[] unicArray(int[] arr){// спробуйте іншу реалізацію, треба для накопичення щось обрати, можливо подивитися у бік класу StringBuilder
        int result = 0;
        int[][] temp = new int[arr.length][2];
        for (int i=0;i<arr.length;i++){
            temp[i][0]=arr[i];
            temp[i][1]=countElement(arr, temp[i][0]);
            result++;
        }
        for (int t=0;t<temp.length;t++){
            for (int f=t+1;f<temp.length;f++){
                if (temp[t][0]==temp[f][0]){
                    temp[t][1]*=-1;
                    result--;
                }
            }
        }
        int counter = 0;
        int[] resultArray = new int[result];
        for (int s=0;s<temp.length;s++){
            if (temp[s][1]>0){
                resultArray[counter]=temp[s][0];
                counter++;
            }
        }
        return resultArray;
    }

    public static int countElement(int[] mas, int element){
        int result=0;
        for (int i=0;i<mas.length;i++){
            if (mas[i]==element){
                result++;
            }
        }
        return result;
    }

        public static String printCountLine(int value){
            String result;
            String num = Integer.toString(value);
            int j = 0;
            int[] resultArr = new int[num.length()];
            while(value!=0)
            {
                resultArr[num.length()-j-1] = value%10;
                value=value/10;
                j++;
            }
            switch (resultArr[num.length()-1]){
                case 2 :
                    result="раза";
                    break;
                case 3 :
                    result="раза";
                    break;
                case 4 :
                    result="раза";
                    break;
                default:
                    result="раз";
            }
            return result;
        }
    }
