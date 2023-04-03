package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.UserDto;

public class UserDAOimpl implements UserDAO {

	@Override
	public int insert(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into users values (?, ?, ?, ?, ?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userDto.getUserSeq());
			ps.setString(2, userDto.getName());
			ps.setString(3, userDto.getEmail());
			ps.setString(4, userDto.getPhone());
			if(userDto.isSleep()) {
				ps.setString(5, "Y");
			}else {
				ps.setString(5, "N");
			}
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int update(UserDto userDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update users set name = ?, email = ?, phone = ?, is_sleep = ? where user_seq = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDto.getName());
			ps.setString(2, userDto.getEmail());
			ps.setString(3, userDto.getPhone());
			if(userDto.isSleep()) {
				ps.setString(4, "Y");
			}else {
				ps.setString(4, "N");
			}
			ps.setInt(5, userDto.getUserSeq());
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public List<UserDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_seq, name, email, phone, is_sleep from users";
		List<UserDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserDto user = new UserDto();
				user.setUserSeq(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSleep(rs.getString(5).equals("Y") ? true : false);
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public UserDto selectOne(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_seq, name, email, phone, is_sleep from users where user_seq = ?";
		UserDto user = new UserDto();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserSeq(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setSleep(rs.getString(5).equals("Y") ? true : false);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return user;
	}

	@Override
	public int delete(int userSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from users where user_seq = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userSeq);
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

}
