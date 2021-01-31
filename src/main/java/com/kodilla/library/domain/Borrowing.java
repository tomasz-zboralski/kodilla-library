package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "BORROWINGS")
public class Borrowing {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VOLUME_ID")
    private Volume volume;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "BORROWED")
    private Date borrowed;

    @Column(name = "RETURNED")
    private Date returned;

}
