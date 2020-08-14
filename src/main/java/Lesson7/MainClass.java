package Lesson7;

import java.util.Arrays;

public class MainClass {


    public static void main(String[] args) throws Exception {

        // проверка заполнения массива
        printFillArray(4,4);
        System.out.println("-------------------------------");
        printFillArray(5,5);
        System.out.println("-------------------------------");
        printFillArray(4,8);
        System.out.println("-------------------------------");
        printFillArray(8,4);
        System.out.println("-------------------------------");
        printFillArray(3,9);
        System.out.println("-------------------------------");
        printFillArray(9,3);
        System.out.println("-------------------------------");
        printFillArray(3,8);
        System.out.println("-------------------------------");
        printFillArray(4,9);
        System.out.println("-------------------------------");

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
