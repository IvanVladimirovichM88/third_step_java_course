package lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
//        //чтение из файла по байтам и вывод на консоль
//        readAndReturnFile();
//
//        // читает 5 фалов и выводит на консоль
//        // !!проблемы с кодировкой
//        try {
//            readFiveFilesAndReturn();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // читаем теже пять фалов выводим на консоль следующую страницу по команде
        try {
            readFilesAndReturnWithCommandEnter();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readAndReturnFile(){
        try ( FileInputStream inputStream = new FileInputStream("pom.xml") ){
            int x;
            while ((x = inputStream.read()) != -1){
                System.out.print((char) x);
            }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static void readFiveFilesAndReturn() throws IOException {
        ArrayList<InputStream> allFiles = new ArrayList<>();
        allFiles.add(new FileInputStream("src/main/java/Lesson1/Basket.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson1/Fruit.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson1/MainClass.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson2/InteractionDB.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson2/InteractionFile.java"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(allFiles));

        int lenReadArray;
        byte[] array = new byte[1024];

        while ((lenReadArray = in.read(array)) != -1){
            System.out.print( new String(array,0,lenReadArray) );
        }

        in.close();
    }

    public static void readFilesAndReturnWithCommandEnter() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<InputStream> allFiles = new ArrayList<>();
        allFiles.add(new FileInputStream("src/main/java/Lesson1/Basket.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson1/Fruit.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson1/MainClass.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson2/InteractionDB.java"));
        allFiles.add(new FileInputStream("src/main/java/Lesson2/InteractionFile.java"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(allFiles));

        int lenReadArray;
        byte[] array = new byte[1024];

        while ((lenReadArray = in.read(array)) != -1){
            System.out.print( new String(array,0,lenReadArray) );
            System.out.println("--------------------------------------------------------------------");
            br.readLine();

        }

        in.close();
    }

}
