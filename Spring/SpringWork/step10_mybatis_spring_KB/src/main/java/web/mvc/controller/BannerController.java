package web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.mvc.service.BannerService;

@RestController
public class BannerController {
   
	@Autowired
	private BannerService bannerService;
	
	/**
	 * Banner정보 가져오기 
	 * */
	@RequestMapping("/banners")
	public List<String> banners(){
		return bannerService.listBanner();
	}
	
}
