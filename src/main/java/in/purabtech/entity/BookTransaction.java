package in.purabtech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_transaction_history")
@Data
public class BookTransaction {

    @Id
    @Column(name="transaction_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Student memberId;


    @ManyToOne
    @JoinColumn(name="book_id")
    private Book bookId;

    @Column(name="date_issue",length=50)
    private Date issuedDate;
    @Column(name="returned_date",length=50)
    private Date returnedDate;
    @Column(name="due_date",length=50)
    private Date dueDate;
    @Column(name="fine_collected")
    private int fineAmount;
    @Column(name="transaction_status", length=50)
    private String transactionStatus;
}
