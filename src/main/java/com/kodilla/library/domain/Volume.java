package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "VOLUMES")
public class Volume {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "volume",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowing> borrowingList = new ArrayList<>();


}
