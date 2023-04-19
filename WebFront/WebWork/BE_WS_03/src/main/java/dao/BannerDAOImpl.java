package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;

public class BannerDAOImpl implements BannerDAO {
	
	private static BannerDAO instance = new BannerDAOImpl();
	
	private BannerDAOImpl() {}
	public static BannerDAO getInstance() {
		return instance;
	}

	@Override
	public List<String> listBanner() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from banner";
		List<String> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
