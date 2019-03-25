package pl.martyna.universities.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.TypeDef;
import pl.martyna.universities.model.enums.PostgreSQLEnumType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "fieldofstudy")
@Getter @Setter
public class FieldOfStudy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nameofstudyfield")
    private String nameOfStudyField;
    @Column(name = "startdate")
    private LocalDate startDate;
    @Column(name = "studentslimit")
    private Integer studentsLimit;
    @Column(name = "grade")
    private Double grade;
}


