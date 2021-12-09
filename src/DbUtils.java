import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
    public static Connection getCon() throws Exception {
        final String URL = "jdbc:mysql://localhost:3308/boardbasic";
        final String USER_NAME = "root";
        final String PASSWORD = "koreait";
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        System.out.println("연결 성공!");
        return con;
    }

    public static void close(Connection con, PreparedStatement ps) {
        close(con, ps, null);
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        if(ps != null) {
            try { ps.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        if(con != null) {
            try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
