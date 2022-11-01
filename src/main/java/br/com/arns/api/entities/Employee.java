package br.com.arns.api.entities;

import br.com.arns.api.enums.ProfileEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "hour_value")
    private BigDecimal hourValue;

    @Column(name = "hours_worked_in_day")
    private Float hoursWorkedInDay;

    @Column(name = "hours_in_lunch")
    private Float hoursInLunch;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private ProfileEnum profile;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entry> entries;

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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", hourValue=" + hourValue +
                ", hoursWorkedInDay=" + hoursWorkedInDay +
                ", hoursInLunch=" + hoursInLunch +
                ", profile=" + profile +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
