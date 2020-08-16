package Lesson6;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] array = {1,1,1,1,2,3,5,6,7,8,9};
        int []  newArray = null;

        try {
            newArray = MyClass.myFirstMethod(array);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(newArray));
        System.out.println(MyClass.mySecondMethod(array));
    }

}
