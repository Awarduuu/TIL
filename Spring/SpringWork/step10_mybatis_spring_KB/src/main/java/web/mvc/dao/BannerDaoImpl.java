package web.mvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BannerDaoImpl implements BannerDao{
	 public static final String NS="ns.sql.bannerMapper.";
	 
	@Autowired
	private SqlSession session;
	
	@Override
	public List<String> listBanner() {
		return session.selectList(NS+"selectAll");
	}

}
