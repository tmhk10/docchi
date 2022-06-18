package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	      String sql = "SELECT ID, NAME, PASS FROM user_tb WHERE NAME = ? AND PASS = ?";
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
	        
	        account = new Account(id, name, pass);
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
}