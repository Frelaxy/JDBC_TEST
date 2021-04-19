package database.contacts;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContMain {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/contacts";
    static final String USER = "root";
    static final String PASSWORD = "12345";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        /**
         * Connection to database
         */
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        /**
         * Adding contacts in table
         */
        int rows1 = statement.executeUpdate("DELETE FROM contacts WHERE id < 190");
        int rows = statement.executeUpdate("INSERT INTO contacts(name, number) VALUES ('Sasha', '4792')," + "('Kirill','4024'), ('Julia','3391')");



        /**
         * retrieving data from a table
         */
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
        ArrayList<Contacts> cont = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            cont.add(new Contacts(name,number));
        }

        for (int i = 0; i < cont.size(); i++) {
            System.out.println(i+1 + ". " + cont.get(i).getName());
        }

        /**
         * Output
         */
        System.out.println("Чей номер вы хотите узнать?");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        System.out.println("Номер: " + cont.get(i-1).getNumber());

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}


