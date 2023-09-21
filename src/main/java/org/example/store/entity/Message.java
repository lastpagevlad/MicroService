package org.example.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @NotBlank(message = "messageSend does not exist")
    @Column
    private String messageSend;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateSending;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
