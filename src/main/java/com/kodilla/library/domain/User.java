package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "USERS")
public class User {

    @NonNull
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name = "FIRSTNAME")
    private String name;

    @NonNull
    @Column(name = "LASTNAME")
    private String surname;

    @NonNull
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
