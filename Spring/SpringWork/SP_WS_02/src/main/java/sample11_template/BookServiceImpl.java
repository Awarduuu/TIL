package sample11_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao; 
	
	@Autowired
	private MessageSender messageSender; 
	
	
	@Autowired
	private EmailSender emailSender;
	

	@Override
	public void save(BookDTO book1, BookDTO book2) {
		bookDao.save(emailSender, messageSender, book1, book2);

	}

}
