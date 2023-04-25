package sample11_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class BookController {
	
	@Autowired
   private BookService bookService;
   
	@Autowired
   private BookDTO book1;
	
	@Autowired
   private BookDTO book2;
  
   public void invoker() {
	   bookService.save(book1, book2);
   }
   
}
