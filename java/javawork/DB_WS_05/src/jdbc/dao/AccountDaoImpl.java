package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.AccountDto;
import jdbc.dto.UserAccountCntDto;
import jdbc.dto.UserDto;

public class AccountDaoImpl implements AccountDao{

	private static AccountDaoImpl instance = new AccountDaoImpl();
	
	private AccountDaoImpl() {}
	
	public static AccountDaoImpl getInstance() {
		return instance;
	}

	
	@Override
	public int insert(AccountDto accountDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into account values (?, ?, ?, ?)";
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountDto.getAccountSeq());
			ps.setString(2, accountDto.getAccountNumber());
			ps.setInt(3, accountDto.getBalance());
			ps.setInt(4, accountDto.getUserSeq());
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int update(AccountDto accountDto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update account set account_number = ?, balance = ? where account_seq = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, accountDto.getAccountNumber());
			ps.setInt(2, accountDto.getBalance());
			ps.setInt(3, accountDto.getAccountSeq());
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int accountSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from account where account_seq = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountSeq);
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public List<AccountDto> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select account_seq, account_number, balance, user_seq from account";
		List<AccountDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountDto account = new AccountDto();
				account.setAccountSeq(rs.getInt(1));
				account.setAccountNumber(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setUserSeq(rs.getInt(4));
				list.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public AccountDto selectOne(int accountSeq) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select account_seq, account_number, balance, user_seq from account"
				+ " where account_seq = ?";
		AccountDto account = new AccountDto();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountSeq);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				account.setAccountSeq(rs.getInt(1));
				account.setAccountNumber(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setUserSeq(rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return account;
	}

	@Override
	public List<AccountDto> selectBalanceDescTop3() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select aa.* from \r\n"
				+ "(select a.*, rownum rnum from \r\n"
				+ "(select * from account order by balance desc ) a \r\n"
				+ ") aa \r\n"
				+ "where aa.rnum <= 3";
		List<AccountDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountDto account = new AccountDto();
				account.setAccountSeq(rs.getInt(1));
				account.setAccountNumber(rs.getString(2));
				account.setBalance(rs.getInt(3));
				account.setUserSeq(rs.getInt(4));
				list.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<AccountDto> selectUsersAccountByName(String searchName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select u.name, a.account_seq, a.account_number, a.balance, a.user_seq\r\n"
				+ "from account a, users u \r\n"
				+ "where a.user_seq = u.user_seq \r\n"
				+ "and u.name like ?";
		List<AccountDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+ searchName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountDto account = new AccountDto();
				account.setName(rs.getString(1));
				account.setAccountSeq(rs.getInt(2));
				account.setAccountNumber(rs.getString(3));
				account.setBalance(rs.getInt(4));
				account.setUserSeq(rs.getInt(5));
				list.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<UserAccountCntDto> selectUserAccountCnt() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select u.user_seq, u.name, nvl(a.account_cnt, 0) account_cnt \r\n"
				+ "from users u left outer join \r\n"
				+ "( select user_seq, count(*) account_cnt from account group by user_seq ) a \r\n"
				+ "on u.user_seq = a.user_seq";
		List<UserAccountCntDto> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserAccountCntDto cnt = new UserAccountCntDto();
				cnt.setUserSeq(rs.getInt(1));
				cnt.setName(rs.getString(2));
				cnt.setAccountCnt(rs.getInt(3));
				list.add(cnt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	
}
