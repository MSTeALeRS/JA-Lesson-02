package ua.lviv.lgs;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {


        BooksDao booksDao = new BooksDao((Connection) ConnectionUtils.openConnection());
      // READ-ALL
        booksDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        List<Book> Books = new ArrayList<>();
//        Books.add(new Book("Jim", "Nilson", "Fantasy"));
//        Books.add(new Book("Tom", "Cruze", "History"));
//        Books.add(new Book("Aron", "Sinelnikov", "Anatomy"));


         // INSERT
        Books.forEach(Book -> {
            try {
                booksDao.insert(Book);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        // READ-ById
        Book bookFromBD = booksDao.read(3);
        System.out.println(bookFromBD);
        System.out.println("\n");

        // UPDATE - ById
//        bookFromBD.setName(bookFromBD.getName() + "+this");
//        booksDao.update(bookFromBD);


        //DEL
        booksDao.delete(11);

        // READ-ALL
        booksDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

    }


}
