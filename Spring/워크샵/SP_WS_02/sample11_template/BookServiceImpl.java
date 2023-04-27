package sample11_template;



public class BookServiceImpl implements BookService {
	
	
	private BookDAO bookDao; 
	
	
	private MessageSender messageSender; 
	
	
	
	private EmailSender emailSender;
	

	@Override
	public void save(BookDTO book1, BookDTO book2) {
		bookDao.save(emailSender, messageSender, book1, book2);

	}

}
