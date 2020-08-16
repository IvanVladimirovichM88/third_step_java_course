package Lesson2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class InteractionFile {

    public static ArrayList<String> readFile(String file) throws IOException {

        Path path = Paths.get(file);
        ArrayList<String> fileLine = new ArrayList<>();

        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()){
            fileLine.add(scanner.nextLine());
        }
        return fileLine;
    }
}
