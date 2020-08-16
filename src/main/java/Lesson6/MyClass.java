package Lesson6;

public class MyClass {
    //Написать метод, которому в качестве аргумента передается
    // не пустой одномерный целочисленный массив.
    // Метод должен вернуть новый массив, который получен путем
    // вытаскивания из исходного массива элементов, идущих после
    // последней четверки. Входной массив должен содержать хотя бы
    // одну четверку, иначе в методе необходимо выбросить
    // RuntimeException.
    public static int[] myFirstMethod(int[] array) throws Exception{
        // проверка на наличие 4
        int pointer = -1;
        for (int i=0; i<array.length; i++){
            if (array[i] == 4){
                pointer = i+1;
            }
        }
        if(pointer == -1){
            throw new RuntimeException("in this array does not contain 4");
        }else if (pointer == array.length){
            throw new RuntimeException("digit 4 is last in this array");
        }else {
            int newLen = array.length - pointer;
            int[] newArray = new int[newLen];
            for (int i = pointer, j=0; i<array.length; i++, j++){
                newArray[j] = array[i];
            }
            return newArray;
        }
    }
    //Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы,
    // то метод вернет false;

    public static boolean mySecondMethod(int[] array){
        int count = 0;
        for(int i=0; i<array.length; i++){
            if (count != 5){
                if ((count != 1) & (array[i] == 1)) {
                    count += 1;
                }
                if ((count != 4) & (array[i] == 4)) {
                    count += 4;
                }
            }
            if( (array[i] != 1) & (array[i] != 4) ){
                return false;
            }
        }
        return (count == 5);
    }
}
