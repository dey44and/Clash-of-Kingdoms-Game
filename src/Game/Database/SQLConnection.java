package Game.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
    private Connection c = null;
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + "game" + ".db");
            Statement stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS \"Users\" (\n" +
                    "\t\"Name\"\tTEXT NOT NULL,\n" +
                    "\t\"Level\"\tINTEGER NOT NULL,\n" +
                    "\t\"TimePlayed\"\tINTEGER NOT NULL,\n" +
                    "\t\"BestScore\"\tINTEGER NOT NULL,\n" +
                    "\t\"TotalScore\"\tINTEGER NOT NULL,\n" +
                    "\tPRIMARY KEY(\"Name\")\n" +
                    ")";
            stmt.execute(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public void insert(String sql) throws SQLException {
        c.setAutoCommit(false);
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

}
