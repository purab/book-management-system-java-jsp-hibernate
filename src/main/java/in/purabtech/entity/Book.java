package in.purabtech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookId;

    @Column(name="book_author", length =100)
    private String bookAuthor;

    @Column(name="book_name", length =100)
    private String bookName;

    @Column(name="book_price", length =10)
    private Double bookPrice;

    @Column(name="book_isbn_number", length =40)
    private String bookNumber;

    @Column(name="status", length =20)
    private String status;

    @Column(name="edition", length =20)
    private String edition;

    @Column(name="date_purchase", length =40)
    @Temporal(TemporalType.DATE)
    private Calendar purchageDate;

    @Column(name="number_copies", length =10)
    private int numberOfCopies;
}
