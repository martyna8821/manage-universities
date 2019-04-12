package pl.martyna.universities.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "University")
@Table(name = "university")
@Getter @Setter
public class University implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //UUID
    @Column(name = "name")
    private String name;
    @Column(name = "additiontime")
   @Temporal(TemporalType.TIMESTAMP)
    private Date addistionDate;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany
    @JoinColumn(name = "universityid")
    private List<FieldOfStudy> fieldsOfStudy = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "university_student",
            joinColumns = { @JoinColumn(name = "id_u") },
            inverseJoinColumns = { @JoinColumn(name = "id_s") }
    )
    Set<Student> students = new HashSet<>();


    public void setId(int id){
        this.id = UUID.fromString(Integer.toString(id));
    }
}
