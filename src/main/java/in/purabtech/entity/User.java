package in.purabtech.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="full_name", length=150)
    private String fullName;
    @Column(name="user_name", length=100)
    private String username;
    @Column(name="user_pass", length=200)
    private String password;
    @Column(name="email", length=50)
    private String email;
    @Column(name="phone", length=15)
    private String phone ;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
