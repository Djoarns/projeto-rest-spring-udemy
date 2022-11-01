package br.com.arns.api.entities;

import br.com.arns.api.enums.TypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    //validar como fica no banco dessa forma sem o name
    private String description;

    private String location;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeEnum type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date current = new Date();
        updateDate = current;
        creationDate = current;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", type=" + type +
                '}';
    }
}
