package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import dto.UserDto;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public UserDto login(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where email = ?";
		UserDto user = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				boolean isSleep = true;
				if(rs.getString(5).equals("N")) {
					isSleep = false;
				}
				user = new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), isSleep, rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
