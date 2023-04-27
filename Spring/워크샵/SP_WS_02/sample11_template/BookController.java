package sample11_template;


public class BookController {
	
	
   private BookService bookService;
   
	
   private BookDTO book1;
	
	
   private BookDTO book2;
  
   public void invoker() {
	   bookService.save(book1, book2);
   }
   
}
