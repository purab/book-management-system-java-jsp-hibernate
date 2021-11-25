package in.purabtech.service;

import in.purabtech.config.DbConnection;
import in.purabtech.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    public List<Book> getAllBooks(){
        Connection con = DbConnection.getConnection();
        Statement st;
        List<Book> books= new ArrayList<Book>();

        try {
            st = con.createStatement();
            ResultSet rs= st.executeQuery("select *from books");
            while (rs.next()) {
                Book book= new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookName(rs.getString("book_name"));
                book.setBookNumber(rs.getString("book_isbn_number"));
                book.setBookPrice(rs.getDouble("book_price"));
                book.setEdition(rs.getString("edition"));
                book.setNumberOfCopies(rs.getInt("number_copies"));
                book.setPurchaseDate(rs.getDate("date_purchase"));
                book.setNumberOfCopies(rs.getInt("number_copies"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
