package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FileNames;

public class PairDAO {
	  // データベース接続に使用する情報
	 
 	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";

	  public List<FileNames> findAll() {
	    List<FileNames> pairList = new ArrayList<FileNames>();

	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	      // SELECT文の準備
	      String sql = "SELECT ID,FILENAME1,FILENAME2 FROM pairs_tb ORDER BY ID DESC";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      // SELECT文の結果をArrayListに格納
	      while (rs.next()) {
	        int id = rs.getInt("ID");
	        String fileName1 = rs.getString("FILENAME1");
	        String fileName2 = rs.getString("FILENAME2");
	        FileNames fileNames = new FileNames(id, fileName1, fileName2);
	        pairList.add(fileNames);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    return pairList;
	  }
	  
	  
	  public boolean create(FileNames fileNames) {
	     // データベース接続
	     try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = "INSERT INTO pairs_tb(FILENAME1, FILENAME2, VOTECOUNT1, VOTECOUNT2) VALUES(?, ?, 0, 0)";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setString(1, fileNames.getFileName1());
		      pStmt.setString(2, fileNames.getFileName2());

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
