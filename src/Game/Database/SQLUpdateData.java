package Game.Database;

import java.sql.*;

public class SQLUpdateData {
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
    public void updateData(String name, int level, int time, int bestScore, int totalScore) throws SQLException {
        String sql =
                "UPDATE Users " +
                        "  SET Level = ?, " +
                        "  SET TimePlayed = ?" +
                        "  SET BestScore = ?, " +
                        "  SET TotalScore = ? " +
                        "WHERE Name = ?";
        //PreparedStatement pstmt = c.prepareStatement(sql);
        //pstmt.setInt(1, level);
        //pstmt.setInt(2, time);
        //pstmt.setInt(3, bestScore);
        //pstmt.setInt(4, totalScore);
        //pstmt.setString(5, name);
        //pstmt.executeUpdate();
        //Statement stmt = c.createStatement();
        //PreparedStatement st = c.prepareStatement("UPDATE Users set Time=?, BestScore=?, TotalScore=? where Name=?)");
        //st.setInt(1, time);
        //st.setInt(2, bestScore);
        //st.setInt(3, totalScore);
        //st.setString(4, name);
        //int updateStatus=st.executeUpdate();
    }
    public void disconnect() throws SQLException {
        c.close();
    }
}
