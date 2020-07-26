package Lesson2;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {

        try {
            InteractionDB.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String tableName = "Stud";
        String fileName = "test.txt";

        try {
            InteractionDB.createTable(tableName);
            InteractionDB.addRowsFromFile(tableName, fileName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        InteractionDB.disconnect();
    }

}
