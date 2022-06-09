package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.FileNames;
import model.Votes;

public class VotesDAO {
	  // データベース接続に使用する情報
	 
	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";

	  
	  public Votes findOne(FileNames fileNames) {

	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	      // SELECT文の準備
	      String sql = "SELECT ID,VOTECOUNT1,VOTECOUNT2 FROM pairs_tb WHERE ID=? AND (FILENAME1=? OR FILENAME2=?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	      pStmt.setInt(1, fileNames.getId());
	      pStmt.setString(2, fileNames.getFileName1());
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      // SELECT文の結果をVotesに格納
	        int ID = rs.getInt("ID");
	        int VOTECOUNT1 = rs.getInt("VOTECOUNT1");
	        int VOTECOUNT2 = rs.getInt("VOTECOUNT2");
	        Votes votes = new Votes(ID, VOTECOUNT1, VOTECOUNT2);
	        
	        return votes;        
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }	    
	 }
	  public boolean update(Votes votes) {
	    // データベース接続
	    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // UPDATE文の準備
		      String sql = "UPDATE votes_tb SET VOTECOUNT1=?, VOTECOUNT2=?  WHERE ID=?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setInt(1, votes.getVote1());
		      pStmt.setInt(2, votes.getVote2());
		      pStmt.setInt(3, votes.getId());

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
