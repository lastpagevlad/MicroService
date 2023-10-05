package org.example.store.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column
    @NotEmpty(message = "name should not be empty")
    private String name;
    @Column
    @NotEmpty(message = "surname should not be empty")
    private String surname;
    @Column
    @NotEmpty(message = "lastname should not be empty")
    private String lastname;
    @Email(message = "Email shpuld be valid")
    private String email;

//    @BatchSize(size = 50)
//    @JsonBackReference
//    @OneToMany(mappedBy = "user")
//    private List<Message> messageList;
}
