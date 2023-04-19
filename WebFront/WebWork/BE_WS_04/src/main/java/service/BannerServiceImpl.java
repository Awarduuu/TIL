package service;

import java.util.List;

import dao.BannerDAO;
import dao.BannerDAOImpl;

public class BannerServiceImpl implements BannerService {

	private static BannerService instance = new BannerServiceImpl();
	
	private BannerDAO bannerDAO = BannerDAOImpl.getInstance();
	
	private BannerServiceImpl() {}
	
	public static BannerService getInstance() {
		return instance;
	}
	
	@Override
	public List<String> listBanner() {
		List<String> list = bannerDAO.listBanner();
		return list;
	}

}
