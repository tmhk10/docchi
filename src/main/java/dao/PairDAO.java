package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pair;

public class PairDAO {
	  // データベース接続に使用する情報
	 
 	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";

	  public List<Pair> findAll() {
	    List<Pair> pairList = new ArrayList<Pair>();

	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	      // SELECT文の準備
	      String sql = "SELECT ID,FILENAME1,FILENAME2 FROM fileName_tb ORDER BY ID DESC";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      // SELECT文の結果をArrayListに格納
	      while (rs.next()) {
	        int id = rs.getInt("ID");
	        String fileName1 = rs.getString("FILENAME1");
	        String fileName2 = rs.getString("FILENAME2");
	        Pair pair = new Pair(id, fileName1, fileName2);
	        pairList.add(pair);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    return pairList;
	  }
	  public boolean create(Pair pair) {
	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = "INSERT INTO fileName_tb(FILENAME1, FILENAME2) VALUES(?, ?)";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setString(1, pair.getFileName1());
		      pStmt.setString(2, pair.getFileName2());

		      // INSERT文を実行
		      int result = pStmt.executeUpdate();

		      if (result != 1) {
		        return false;
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }
		    return true;
		  }	

}
