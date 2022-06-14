package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pair;

public class VotesDAO {
	  // データベース接続に使用する情報
	 
	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";

	  
	  public Pair findOne(Pair tempo) {
		  Pair pair = null;

	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	      // SELECT文の準備
	      String sql = "SELECT * FROM pairs_tb WHERE ID = ? AND (FILENAME1 = ? OR FILENAME2 = ?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	      pStmt.setInt(1, tempo.getId());
	      pStmt.setString(2, tempo.getFileName1());
	      pStmt.setString(3, tempo.getFileName1());
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      // SELECT文の結果をVotesに格納
	      while(rs.next()) {
	        int ID = rs.getInt("ID");
	        String fileName1 = rs.getString("FILENAME1");
	        String fileName2 = rs.getString("FILENAME2");
	        int VOTECOUNT1 = rs.getInt("VOTECOUNT1");
	        int VOTECOUNT2 = rs.getInt("VOTECOUNT2");
	        pair = new Pair(ID, fileName1, fileName2, VOTECOUNT1, VOTECOUNT2);
	      }  
	               
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    return pair; 
	 }
	  
	  public boolean update(Pair pair) {
	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // UPDATE文の準備
		      String sql = "UPDATE pairs_tb SET VOTECOUNT1 = ?, VOTECOUNT2 = ?  WHERE ID = ?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setInt(1, pair.getVote1());
		      pStmt.setInt(2, pair.getVote2());
		      pStmt.setInt(3, pair.getId());

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
