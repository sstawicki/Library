package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE", unique = true)
    private String title;

    @Column(name = "AUTHOR")
    private  String author;

    @Column(name = "PUBLICATION_YEAR")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publicationYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private Set<Copies> copies;

    public Book(String title, String author, LocalDateTime publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}