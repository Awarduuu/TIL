package sample11_template;

public interface BookDAO {
  void save(EmailSender emailSender, MessageSender messagSender, BookDTO book1, BookDTO book2);
}
