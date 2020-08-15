package Lesson7;

import Lesson7.Anatations.MarkingTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainClass {


    public static void main(String[] args) throws Exception {

        // проверка заполнения массива
//        printFillArray(4,4);
//        System.out.println("-------------------------------");
//        printFillArray(5,5);
//        System.out.println("-------------------------------");
//        printFillArray(4,8);
//        System.out.println("-------------------------------");
//        printFillArray(8,4);
//        System.out.println("-------------------------------");
//        printFillArray(3,9);
//        System.out.println("-------------------------------");
//        printFillArray(9,3);
//        System.out.println("-------------------------------");
//        printFillArray(3,8);
//        System.out.println("-------------------------------");
//        printFillArray(4,9);
//        System.out.println("-------------------------------");


        Class  classCat = Cat.class;
        TestingClass.star(classCat);



//        Class myClass = Cat.class;
//        Field[] fields = myClass.getDeclaredFields();
//        Method[] methods = myClass.getDeclaredMethods();
//        for(Field o: fields){
//            System.out.println("Type and name:  " + o.getType().getName() + "  "+ o.getName());
//        }
//
//        for (Method m :
//                methods) {
//            if ( m.getAnnotation(MarkingTest.class) != null )
//            System.out.println(m.getReturnType() + " || " +
//                    m.getName() + " || " + Arrays.toString(m.getParameterTypes()));
//        }
    }

    static void printFillArray( int width, int height){

        int[][] array = new int[height][width];
        int increment = 0;
        int sum =0, i =0, j=0;

        int maxRepeat;
        if  ((width /2 + width %2) < (height /2 + height %2)){
            maxRepeat = width /2 + width %2;
        }else{
            maxRepeat = height /2 + height %2;
        }

        boolean flagHorizontal = false;
        boolean flagVertical = false;
        for (int repeat = 0 ; repeat < maxRepeat; repeat++){
 //           System.out.println("--------------" + repeat );
            i =  repeat;
            j =  repeat;
            sum = i+j;
            array[j][i] = increment++;
   //         System.out.println(i + " , " + j + " , " + sum);

            while ( sum < ( (width -1)+(height -1) ) - 2 * repeat ) {

                flagVertical = false;

                if (i < width - 1 - repeat) {
                    i++;
                } else {
                    j++;
                    flagVertical = true;
                }

                sum = i + j;
                array[j][i] = increment++;
               // System.out.println(i + " , " + j + " , " + sum);

            }
            flagHorizontal = false;


            while ((sum > 1 + 2*repeat) & flagVertical ) {

                if (i > repeat) {
                    i--;
                    flagHorizontal = true;
                } else if (flagHorizontal){
                    j--;
                }else {
                    break;
                }
                sum = i + j;
                array[j][i] = increment++;
     //           System.out.println(i + " , " + j + " , " + sum);
            }
        }


        for (int[] o : array) {
            for (int number : o){
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }
}
