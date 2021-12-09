import java.sql.Connection;
import java.sql.PreparedStatement;

public class MelonDAO {
    public static void insBoard(MelonVO vo) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board (title, ctnt, writer) VALUES (?, ?, 3) ";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getSong());
            ps.setString(2, vo.getSinger());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
    }
}
