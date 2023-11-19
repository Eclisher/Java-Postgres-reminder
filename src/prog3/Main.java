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

//        // Test of findAll for books
        List<Book> allBooks = bookCrudOperation.findAll();
        logger.info("All Books: " + allBooks);

          //test of savebook
        Book newBook = new Book(21, "New Book", 1, 200, Topic.ROMANCE, java.time.LocalDate.now());
        Book savedBook = bookCrudOperation.save(newBook);
        logger.info("Saved Book: " + savedBook);

        Book bookToDelete = new Book(21, null, 0, 0, null, null);
        Book deletedBook = bookCrudOperation.delete(bookToDelete);
        logger.info("Deleted Book: " + deletedBook);

        // Test of findAll for authors
        List<Author> allAuthorsBefore = authorCrudOperation.findAll();
        logger.info("All Authors Before: " + allAuthorsBefore);

        // Test of save for author
        Author newAuthor = new Author(6, "Marc", 'M');
        Author savedAuthor = authorCrudOperation.save(newAuthor);
        logger.info("Saved Author: " + savedAuthor);
//

//        // Test of delete for author
        Author authorDelete = new Author(5, "Marc", 'M');
        Author deletedAuthor = authorCrudOperation.delete(authorDelete);
        logger.info("Deleted Author: " + deletedAuthor);

//        // Test of saveAll for authors
        List<Author> authorsToSave = List.of(
                new Author(9, "Martin Luttin", 'M'),
                new Author(10, "Marc Herver", 'M'),
                new Author(11, "Charlie Solange", 'F')
        );
        List<Author> savedAuthors = authorCrudOperation.saveAll(authorsToSave);
        logger.info("Saved Authors: " + savedAuthors);

                // Test of findAll for visitors
        List<Visitor> allVisitors = visitorCrudOperation.findAll();
        logger.info("All Visitors: " + allVisitors);

                //Test to save visitor
        Visitor newVisitor = new Visitor(4, "harizo", "harizo@gmail.com", "348516898","REF004");
        Visitor savedVisitor = visitorCrudOperation.save(newVisitor);
        logger.info("Saved Visitor: " + savedVisitor);

        // Test of delete for visitor
        Visitor visitorDelete = new Visitor(4, "harizo", "harizo@gmail.com", "348516898","REF004");
        Visitor deletedVisitor = visitorCrudOperation.delete(visitorDelete);
        logger.info("Deleted Visitor: " + deletedVisitor);

        //find all admin
     List<Admin> allAdmins = adminCrudOperation.findAll();
        logger.info("All Admin:" + allAdmins);

        //Test to save admin
        Admin newAdmin = new Admin(4, "harizo", "harizo@gmail.com", "16984561", "azerty" );
        Admin savedAdmin = adminCrudOperation.save(newAdmin);
        logger.info("Saved Admin: " + savedAdmin);

        // Test of delete for admin
        Admin adminDelete = new Admin(7, "harizo", "harizo@gmail.com", "16984561", "azerty" );
        Admin deletedAdmin = adminCrudOperation.delete(adminDelete);
        logger.info("Deleted Admin: " + deletedAdmin);

    }
}
