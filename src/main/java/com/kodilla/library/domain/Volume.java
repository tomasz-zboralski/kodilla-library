package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "VOLUMES")
public class Volume {


    //@NonNull
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @NonNull
    @Column(name = "STATUS")
    private VolumeStatus status;

    @OneToMany(
            targetEntity = Borrowing.class,
            mappedBy = "volume",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borrowing> borrowingList = new ArrayList<>();

    public Volume(Long id, @NonNull Book book, @NonNull VolumeStatus status) {
        this.id = id;
        this.book = book;
        this.status = status;
    }
}
