package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Login;

public class AccountDAO {
	  // データベース接続に使用する情報
	  private final String JDBC_URL ="jdbc:mysql://localhost/docchi";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "(tomo:ebi)1013";
	  
	  public Account findByLogin(Login login) {
		Connection conn = null;		

		Account account = null;
		// データベースへ接続
	    try {

	      //JDBCドライバを最初に読み込む
    	  Class.forName("com.mysql.cj.jdbc.Driver");
    	  //データベースに接続
    	  conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	      // SELECT文を準備
	      String sql = "SELECT ID, NAME, PASS, SEX, DOB FROM user_tb WHERE NAME = ? AND PASS = ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1, login.getName());
	      pStmt.setString(2, login.getPass());

	      // SELECTを実行し、結果表を取得
	      ResultSet rs = pStmt.executeQuery();

	      // 一致したユーザーが存在した場合
	      // そのユーザーを表すAccountインスタンスを生成
	      if (rs.next()) {
	        // 結果表からデータを取得
	    	int id = rs.getInt("ID"); 
	    	String name = rs.getString("NAME");
	        String pass = rs.getString("PASS");
	        String sex = rs.getString("sex");
	        String dob = rs.getString("DOB");
	        account = new Account(id, name, pass, sex, dob);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	        return null;
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
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
	    // 見つかったユーザーまたはnullを返す
	    return account;
	  }
	  
	  
	  public boolean create(Account account) {
		     // データベース接続
		     try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			      // INSERT文の準備(idは自動連番なので指定しなくてよい）
			      String sql = "INSERT INTO user_tb(NAME, PASS, SEX, DOB) VALUES(?, ?, ?, ?)";
			      PreparedStatement pStmt = conn.prepareStatement(sql);
			      // INSERT文中の「?」に使用する値を設定しSQLを完成
			      pStmt.setString(1, account.getName());
			      pStmt.setString(2, account.getPass());
			      pStmt.setString(3, account.getSex());
			      pStmt.setString(4, account.getDob());

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
	  
	  
	  public List<String> findByName() {
		  List<String> nameList = new ArrayList<String>();
		  
	      // データベース接続
		   try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		      // SELECT文の準備
		      String sql = "SELECT NAME FROM user_tb";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      
		      // SELECT文を実行
		      ResultSet rs = pStmt.executeQuery();
		      // SELECT文の結果をArrayListに格納
		      while (rs.next()) {
		    	  String userName = rs.getString("NAME");
		    	  nameList.add(userName);
		      }
		   } catch (SQLException e) {
		       e.printStackTrace();
		       return null;
		   }
		   return nameList;
	 }		  	  
	  
}