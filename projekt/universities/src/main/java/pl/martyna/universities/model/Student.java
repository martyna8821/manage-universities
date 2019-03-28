package pl.martyna.universities.model;

import com.sun.source.doctree.SerialDataTree;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import pl.martyna.universities.model.enums.Gender;
import pl.martyna.universities.model.enums.PostgreSQLEnumType;
import pl.martyna.universities.model.enums.StudentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student")
@TypeDef(name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class)
@Getter @Setter
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private  String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "age")
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Type( type = "pgsql_enum" )
    @Column(columnDefinition = "gender_t")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Type( type = "pgsql_enum" )
    @Column(columnDefinition = "studentstatus_t", name = "studentstatus")
    private StudentStatus studentStatus;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "university_student",
            joinColumns = { @JoinColumn(name = "id_u") },
            inverseJoinColumns = { @JoinColumn(name = "id_s") }
    )
    Set<FieldOfStudy> fieldOfStudy = new HashSet<>();

}
