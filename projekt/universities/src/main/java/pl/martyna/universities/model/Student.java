package pl.martyna.universities.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import pl.martyna.universities.model.enums.Gender;
import pl.martyna.universities.model.enums.PostgreSQLEnumType;
import pl.martyna.universities.model.enums.StudentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_field",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name ="field_id")
    )
    Set<FieldOfStudy> fieldsOfStudy;


}
