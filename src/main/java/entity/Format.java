package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = " format")
@Getter
@Setter
public class Format extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "code", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private FormatCode code;
    @OneToMany(mappedBy = "format")
    private List<Copy> copies;
}
