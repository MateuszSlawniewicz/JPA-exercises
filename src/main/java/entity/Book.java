package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends BaseEntity {

    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "pages_number")
    private int pagesNumber;
    @Column(name = "isbn")
    private long isbn;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public Book() {
    }

    public Book(long id, String title, long isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(Long id) {
        this.id = id;
    }
}