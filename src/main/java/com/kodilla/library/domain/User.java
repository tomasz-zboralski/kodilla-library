package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRSTNAME")
    private String name;

    @Column(name = "LASTNAME")
    private String surname;

    @Column(name = "CREATED")
    private java.sql.Date created;


    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowing> borrowingList = new ArrayList<>();

}
