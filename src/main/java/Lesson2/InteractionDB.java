package Lesson2;



import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class InteractionDB {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement pstmt;


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        statement = connection.createStatement();
    }

    public static void disconnect(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTable(String name) throws SQLException {
        int res = statement.executeUpdate("CREATE TABLE "+ name + " (" +
                "    id    INTEGER PRIMARY KEY," +
                "    name  TEXT," +
                "    count INTEGER" +
                ");");
    }

    public static void  addRow(String name, String str) throws SQLException {
        String[] row = str.split(" ");
        int res = statement.executeUpdate("INSERT INTO "+name+
                                    " (id, name, count) VALUES ('" + row[0] + "', " +
                                    row[1] + "', " +
                                    row[2] + ");");
    }

    public static ResultSet getRow(String name, int id) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT *FROM "+ name +" WHERE id = "+ id +"");
        return  rs;
    }

    public static void deleteRow(String name, int id) throws SQLException {
        int res = statement.executeUpdate("DELETE FROM "+name+" WHERE id = "+ id +";");
    }

    public  static void deleteTable(String name) throws SQLException {
        int res = statement.executeUpdate("DROP TABLE "+ name +";");
    }

    public static void addRowsFromFile(String tableName, String fileName) throws SQLException {

        ArrayList<String> stringsFromFile = null;
        try {
            stringsFromFile = InteractionFile.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pstmt = connection.prepareStatement("INSERT INTO "+ tableName + " (id, name, count) VALUES (?, ?, ?);");
        for (String o : stringsFromFile) {
            String[] row = o.split(" ");

            pstmt.setString(1,row[0]);
            pstmt.setString(2,row[1]);
            pstmt.setString(3,row[2]);

            pstmt.addBatch();
        }
        pstmt.executeBatch();
    }
}
