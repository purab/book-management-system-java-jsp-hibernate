package in.purabtech.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="role_name", length=50)
    private String role;

    @Column(name="role_description", length=150)
    private String description;
}
