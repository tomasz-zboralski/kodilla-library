package com.kodilla.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "BOOKS")
public class Book {

    //@NonNull
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(name = "TITLE")
    private String title;

    @NonNull
    @Column(name = "AUTHOR")
    private String author;

    @NonNull
    @Column(name = "PUBLISHED")
    private int published;


    @OneToMany(
            targetEntity = Volume.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Volume> volumeList = new ArrayList<>();

    public Book(Long id, @NonNull String title, @NonNull String author, @NonNull int published) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getPublished() != book.getPublished()) return false;
        if (getId() != null ? !getId().equals(book.getId()) : book.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        return getAuthor() != null ? getAuthor().equals(book.getAuthor()) : book.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + getPublished();
        return result;
    }
}

