package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author extends BaseEntity {
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @ManyToMany()
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }
}
