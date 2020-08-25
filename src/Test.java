import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        Test var1 = new Test ();
        int mass1[] = {1,2,3,4};
        var1.devTwo(mass1);
        var1.devTwo(mass1, 4);
//        var1.sumArray1(mass1);
//        System.out.println(Arrays.toString(mass1)); // Вывод результата конвертации масива (mass1 - [1,2]) до применения реверс метода и возврата через return!
//        var1.reversArray(mass1);
//        System.out.println(Arrays.toString(mass1)); /// Вывод результата конвертации масива (mass1 - [2, 58]) после return - резульат другой потому что return вернул значение перевёрнутого масива в переменную масива которую подавали на конвертацию

//        int a = 5;
//        int b = 6;
//        var1.sum(a, b); // просто выполнило метод sum выполнив при этом сложение но на экран ничего не вывело (результат вычеслений передало в вызывающую переменную)
//        System.out.println (var1.sum(a, b));
//        System.out.println("7i " + a + b + " y6");
    }


    int devTwo (int [] mas){ // Первая практическая
        int result = 0;
        int i = 0;
        for (; i<mas.length;i++){
            if (mas[i]%2==0) {
                result = result + (mas[i]);
            }
        }
        System.out.println(result);
        return result;
    }
    int devTwo (int [] mas, int par){ // Вторая практическая
        int result = 0;
        for (int temp : mas) {
            if (temp%par==0){
                result = result + temp;
            }
        }
        System.out.println(result);
        return result;
    }

    int sumArray(int [] arr){
        int result = 0;
        for (int temp : arr){
            result=result+temp;
        }
        System.out.println (result);
        return result;
    }

    int sumArray1(int[] arr){
        int i = 0;
        int result = 0;
        while (i<arr.length) {
            result = result + arr[i];
            i++;
        }
        System.out.println (result);
        return result;
    }


    int[] reversArray(int[] arr){
        int[] arr1 = new int[arr.length];
        arr[0] = 58;
        int j = 0;
        for (int i=arr.length-1; i>=0; i--){
            arr1 [j] = arr[i];
            j++;
        }
        for (int temp : arr1){
            System.out.println(temp);
        }
        return arr1;
    }
    int sum(int par1, int par2){
        par1 = 38;
        return par1 + par2;
    }

}
