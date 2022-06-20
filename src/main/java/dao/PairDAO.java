package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Login;
import model.Pair;

public class PairDAO {
	  // データベース接続に使用する情報	 
 	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";

	  public List<Pair> findAll() {
		  Connection conn = null;	
	    List<Pair> pairList = new ArrayList<Pair>();

	    // データベース接続
	    try {
	    	//JDBCドライバを最初に読み込む
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	//データベースに接続
	    	  conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	      // SELECT文の準備
	      String sql = "SELECT * FROM pairs_tb ORDER BY ID DESC";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // SELECTを実行
	      ResultSet rs = pStmt.executeQuery();
	      // SELECT文の結果をArrayListに格納
	      while (rs.next()) {
	        int id = rs.getInt("ID");
	        String fileName1 = rs.getString("FILENAME1");
	        String fileName2 = rs.getString("FILENAME2");
	        int VOTECOUNT1 = rs.getInt("VOTECOUNT1");
	        int VOTECOUNT2 = rs.getInt("VOTECOUNT2");
	        Pair pair = new Pair(id, fileName1, fileName2, VOTECOUNT1, VOTECOUNT2);
	        pairList.add(pair);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
	    }finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
	    return pairList;
	  }
	  
	  
	  public List<Pair> findSome(Login login) {
		    List<Pair> personalList = new ArrayList<Pair>();

		    // データベース接続
		    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // SELECT文の準備
		      String sql = "SELECT * FROM pairs_tb WHERE CONTRIBUTOR = ?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      	pStmt.setString(1, login.getName());
		      // SELECTを実行
		      ResultSet rs = pStmt.executeQuery();
		      // SELECT文の結果をArrayListに格納
		      while (rs.next()) {
		        int id = rs.getInt("ID");
		        String fileName1 = rs.getString("FILENAME1");
		        String fileName2 = rs.getString("FILENAME2");
		        int VOTECOUNT1 = rs.getInt("VOTECOUNT1");
		        int VOTECOUNT2 = rs.getInt("VOTECOUNT2");
		        Pair pair = new Pair(id, fileName1, fileName2, VOTECOUNT1, VOTECOUNT2);
		        personalList.add(pair);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return personalList;
		  }
	  
	  
	  public boolean create(Pair pair, Login login) {
	     // データベース接続
	     try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = "INSERT INTO pairs_tb(FILENAME1, FILENAME2, VOTECOUNT1, VOTECOUNT2, CONTRIBUTOR) VALUES(?, ?, 0, 0, ?)";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      // INSERT文中の「?」に使用する値を設定しSQLを完成
		      pStmt.setString(1, pair.getFileName1());
		      pStmt.setString(2, pair.getFileName2());
		      pStmt.setString(3, login.getName());

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
	  
	  
	  public boolean remove(int id) {
		    // データベース接続
		    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			      // UPDATE文の準備
			      String sql = "DELETE FROM pairs_tb  WHERE ID = ?";
			      PreparedStatement pStmt = conn.prepareStatement(sql);
			      // INSERT文中の「?」に使用する値を設定しSQLを完成
			      pStmt.setInt(1, id);

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
