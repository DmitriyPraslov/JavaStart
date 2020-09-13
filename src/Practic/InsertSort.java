package Practic;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] arr = {7,2,8,3,6,0,5};
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    void insertSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){  // arr.length-1 для того что бы не выйти за пределы массива
            if (arr[i]>arr[i+1]){      // сравниваем последний элемент отсортированого массива с первым элементом не отсортированого
                insertElement(arr, i+1); // если новый элемент не отсортированого массива меньше последнего отсортированого, то ищем для него место
            }
        } // если последний элемент отсортированого массива меньше первого из не отсортированого то мы не делаем ничего, переходим на следующую итерацию
    }
    private void insertElement(int[] arr, int index) { // в метод поступает массив и индекс элемента для которого ищем место
        int newPosition = findNewPosition(arr, index); // вызов метода который находит и возвращает новую позицию (индекс элемента) куда нужно вставить элемент
        Shift(arr, newPosition, index); // вызов метода который сдвигает элементы начиная с элемента на место которого
                    // он становится и заканчивая позицией элемента для которого мы выполняем поиск позиции куда вставить

    } // ВЕСЬ ЭТОТ МЕТОД РАБОТАЕТ ТОЛЬКО ЕСЛИ СРАБОТАЛ if В МЕТОДЕ КОТОРЫЙ ЕГО ВЫЗЫВАЕТ!!!!!!

    private void Shift(int[] arr, int newPosition, int index) { // нужно поставить в индекс newPosition (0) -> элемент под индексом index - (2)
        int temp1=arr[index];
        for (int i=index;i>newPosition;i--){
            arr[i]=arr[i-1];
        }
        arr[newPosition]=temp1;
    }

    private int findNewPosition(int[] arr, int index) { // поиск места для (i+1) элемента массива
        int result=0; // в эту переменную будет записана позиция куда элемент нужно вставить в методе - insertElement
        for(int i=0;i<index;i++){ // идём в цикле от первого элемента до элемента, для которого ищем место, индекс
            if (arr[i]>=arr[index]){ // зайдём в условие только в том случае когда элемент, на место которого нужно поставить элемент
                                    // равен или больше самого элемента
                result = i; // присваиваем позицию на место которой нужно будет вставить элемент
                break; // заканчиваем наш цикл
            }
        }
        return result; // возвращаем позицию
    }
}
