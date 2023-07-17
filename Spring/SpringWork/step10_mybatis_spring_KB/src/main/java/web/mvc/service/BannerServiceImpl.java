package  web.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.mvc.dao.BannerDao;
import web.mvc.dao.BannerDaoImpl;

@Service
public class BannerServiceImpl implements BannerService{
	@Autowired
    private BannerDao bannerDao;
	
	@Override
	public List<String> listBanner() {
		
		return bannerDao.listBanner();
	}

}
