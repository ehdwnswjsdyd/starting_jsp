package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //sql�� ���� ���� ���ڵ尪�� ���̺����·� ����
	
	
	public UserDAO() {
		try {
			String dbURL="jdbc;mysql://localhost:3300/BBS";// ���⼭ BBS�� �����ͺ��̽� ��, jdbc�� �ڹ� api��
			String dbID="root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.driver");//���⼭ driver�� mysql �� �����ϰ� ���ִ� �Ű�ü
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		    //���� ������ mysql �� �������ִ� �κ���
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
			return -1;//rs�� ���� ������ ���̵��� ���°ŹǷ� ���̵� ���ٰ� ��ȯ
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
	}
}
