package Lesson_11_12;
import java.sql.*;
import java.util.Scanner;

public class ConnectToDB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stopSearching = new String("");
        while (!stopSearching.equals("|")) {
            String subStringForSearch = scan.nextLine();
            stopSearching = subStringForSearch;
            Connect con1 = new Connect();
            con1.connect(subStringForSearch);
        }
    }
}

class Connect {
    /**
     * Connect to a sample database
     */
    public static void connect(String subStringForSearch) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\Mogromir\\Downloads\\chinook\\chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

//            System.out.println("Connection to SQLite has been established.");

            Statement stat = conn.createStatement();

            ResultSet rs  = stat.executeQuery("Select Name From artists where Name LIKE '"+subStringForSearch+"%'");
            while (rs.next()==true){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
}
