package src.prog3;
import java.util.List;
import java.util.logging.Logger;

import src.prog3.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        BookCrudOperation bookCrudOperation = new BookCrudOperation();
        AuthorCrudOperation authorCrudOperation = new AuthorCrudOperation();
        VisitorCrudOperation visitorCrudOperation = new VisitorCrudOperation();
        AdminCrudOperation adminCrudOperation = new AdminCrudOperation();

        // Test of findAll for books
        List<Book> allBooks = bookCrudOperation.findAll();
        logger.info("All Books: " + allBooks);

        // Test of findAll for authors
        List<Author> allAuthors = authorCrudOperation.findAll();
        logger.info("All Authors: " + allAuthors);

        // Test of findAll for visitors
        List<Visitor> allVisitors = visitorCrudOperation.findAll();
        logger.info("All Visitors: " + allVisitors);

        List<Admin> allAdmins = adminCrudOperation.findAll();
        logger.info("All Admin:" + allAdmins);
    }
}
