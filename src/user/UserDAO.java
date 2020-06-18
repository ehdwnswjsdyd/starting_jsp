package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //sql을 통해 얻은 레코드값을 테이블형태로 저장
	
	
	public UserDAO() {
		try {
			String dbURL="jdbc;mysql://localhost:3300/BBS";// 여기서 BBS는 데이터베이스 명, jdbc는 자바 api임
			String dbID="root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.driver");//여기서 driver는 mysql 에 접근하게 해주는 매개체
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		    //여기 까지가 mysql 과 연결해주는 부분임
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public int longin(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
			}
			return -1;//rs에 값이 없으면 아이디값이 없는거므로 아이디 없다고 반환
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}
}
