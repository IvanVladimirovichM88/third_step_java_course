package lesson3;

import Lesson2.InteractionDB;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //чтение из файла по байтам и вывод на консоль
        readAndReturnFile();

        // читает 5 фалов и выводит на консоль
        try {
            readFiveFilesAndReturn();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // читаем файл и выводим указанную страницу в консоль
        try {
            readFilesAndReturnWithCommandEnter();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void readAndReturnFile(){

        ArrayList<Character> charBuffer = new ArrayList<>();
        try ( FileInputStream inputStream = new FileInputStream("pom.xml") ){
            int x;
            while ((x = inputStream.read()) != -1){
                charBuffer.add((char)x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // print
        for (char o: charBuffer){
            System.out.print(o);
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

        final int BUFFER_LEN = 1800;
        File file = new File("C:/Program Files/Java/jre1.8.0_251/THIRDPARTYLICENSEREADME-JAVAFX.txt");
        System.out.println( "len of file - " + file.length());
        int maxPage = 0;

        if ( file.length() % BUFFER_LEN == 0 ){
            maxPage = (int)(file.length() / BUFFER_LEN);
        }else{
            maxPage = (int)(file.length() / BUFFER_LEN) + 1;
        }

        System.out.println( "max page - " + maxPage );
        byte[] array = new byte[BUFFER_LEN];

        Scanner scanner = new Scanner(System.in);
        int page = 1;

        while (page>0 & page <= maxPage) {

            try(RandomAccessFile raf = new RandomAccessFile(file, "r")) {

                if ((page == maxPage) && (file.length() % BUFFER_LEN != 0)){
                    byte[] arrayTail = new byte[ (int)file.length()%BUFFER_LEN ];
                    raf.seek((page-1)*BUFFER_LEN);
                    raf.readFully( arrayTail );
                    System.out.println();
                    for (byte o : arrayTail) {
                        System.out.print((char) o);
                    }
                }else {
                    raf.seek((page-1)*BUFFER_LEN);
                    raf.readFully(array);
                    System.out.println();
                    for (byte o : array) {
                        System.out.print((char) o);
                    }
                }
            }

            System.out.println("\n--> Укажите номер страницы, но не более - " + maxPage +
                    " \n в случае некорректной страницы программа закрывается" );
            System.out.print("-->");


            String str = scanner.nextLine();
            try {
                page  = Integer.parseInt(str);
            }catch (NumberFormatException e){
                page  = 0;
            }

        }
    }
}
