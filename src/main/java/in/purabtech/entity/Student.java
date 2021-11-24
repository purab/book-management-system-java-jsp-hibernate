package in.purabtech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="full_name")
    private String FullName;
    @Column(name="university_id")
    private String universityId;
    @Column(name="student_address")
    private String address;
    @Column(name="admission_date")
    private Date admissionDate;
    @Column(name="max_book_limit")
    private int maxBookAllowed;
    @Column(name="accademic_year")
    private String academicYear;
    @Column(name="no_books_issued")
    private int booksIssued;
}
