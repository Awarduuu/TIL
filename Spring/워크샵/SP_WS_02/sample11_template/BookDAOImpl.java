package sample11_template;


public class BookDAOImpl implements BookDAO {
	
  	
  private DbUtil dbUtil;
  
	@Override
	public void save(EmailSender emailSender, MessageSender messagSender, BookDTO book1, BookDTO book2) {
		System.out.println("emailSender = " + emailSender);
		System.out.println("messagSender = " + messagSender);
		System.out.println("book1 = " + book1);
		System.out.println("book2 = " + book2);
		System.out.println("dbUtil = " + dbUtil);
	}

}
