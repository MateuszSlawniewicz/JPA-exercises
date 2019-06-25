package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select c from Category c"),
        @NamedQuery(name = "Category.findAllBooksFromCategory", query = "select c, b from Category c join c.books b where c.code = :categoryCode"),
        @NamedQuery(name = "Category.findCodes", query = "select c from Category  c where  c.code in (:categoryCodes)")
})

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity {

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "code", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryCode code;

    @OneToMany(mappedBy = "category")
    private List<Book> books;
}