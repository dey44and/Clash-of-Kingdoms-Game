package Game.Database;

import java.sql.*;

public class SQLGetData {
    private Connection c = null;
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + "game" + ".db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public SessionInfo getData(String name) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM Users WHERE Name='"+ name + "';" );
        return new SessionInfo(rs.getString("Name"), rs.getInt("Level"), rs.getInt("TimePlayed"), rs.getInt("BestScore"), rs.getInt("TotalScore"));
    }
    public void disconnect() throws SQLException {
        c.close();
    }
}
