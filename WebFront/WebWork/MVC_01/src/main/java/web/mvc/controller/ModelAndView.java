package web.mvc.controller;
/**
 *  Controller를 실행한 후 어떤 뷰페이지로 이동할 것인지? -> viewName
 *  어떤 이동 방식으로 이동할 것인지? -> isRedirect
 *  결정하는 속성을 관리하는 객체 (POJO)
 * */
public class ModelAndView {
   private String viewName; //이동할 뷰 이름
   private boolean isRedirect; //이동방식(true이면 redirect, false이면 forward)
   
   public ModelAndView() {}
   public ModelAndView(String viewName) {
	   this.viewName = viewName;
   }
  public ModelAndView(String viewName, boolean isRedirect) {
	this(viewName);
	this.isRedirect = isRedirect;
 }
  
  
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
  
  
   
}
