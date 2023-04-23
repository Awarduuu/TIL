package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import dto.UserDto;

public class UserDaoImpl implements UserDao{

	private static UserDao instance = new UserDaoImpl();
	
	private UserDaoImpl() {}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	@Override
	public int register(UserDto userDto) {
		String sql = "insert into users (user_seq, name, email, phone, password) values (user_seq.nextval, ?, ?, ?, ?) ";
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getName());
			pstmt.setString(2, userDto.getEmail());
			pstmt.setString(3, userDto.getPhone());
			pstmt.setString(4, userDto.getPassword());
			
			ret = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, pstmt);
		}
		
		return ret;
	}

	@Override
	public boolean confirmPassword(int userSeq, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select password from users where user_seq = ?";
		boolean result = false;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					result = true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int changePassword(int userSeq, String password) {
		String sql = "update users set password = ? where user_seq = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, userSeq);
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}

}
