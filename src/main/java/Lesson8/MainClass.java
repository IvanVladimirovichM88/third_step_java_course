package Lesson8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] arrayCount = new int[20];
        ArrayList<Integer> mass = new ArrayList<>();
        Arrays.fill(arrayCount, 0);
        Path path = Paths.get("fileForLesson8.txt");

        try(InputStream in = Files.newInputStream(path)){
            BufferedReader reader =
                    (new BufferedReader(new InputStreamReader(in)));
            String line = null;
            while ((line = reader.readLine()) !=null){
                String[] str = line.split(" ");
                for (String s :
                        str) {
                    mass.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int count =0;
        for (Integer i: mass){
            if (count == 30){
                System.out.println();
                count = 0;
            }
            System.out.print(i+" ");
            arrayCount[i] ++;
            count++;
        }

        System.out.println();
        count = 0;
        for (int i :
                arrayCount) {
            System.out.println( "Числа  -> \t"+count+
                    "\tповторяются -> " + i +" раз");
            count ++;
        }



    }
}
