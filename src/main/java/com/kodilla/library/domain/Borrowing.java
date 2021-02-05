package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "BORROWINGS")
public class Borrowing {

    @NonNull
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "VOLUME_ID")
    private Volume volume;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @NonNull
    @Column(name = "BORROWED")
    private Date borrowed;

    @NonNull
    @Column(name = "RETURNED")
    private Date returned;

}
