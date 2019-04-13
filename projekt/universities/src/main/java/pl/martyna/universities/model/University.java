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

    public UUID getId() {
        return id;
    }

    public University() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddistionDate() {
        return addistionDate;
    }

    public void setAddistionDate(Date addistionDate) {
        this.addistionDate = addistionDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<FieldOfStudy> getFieldsOfStudy() {
        return fieldsOfStudy;
    }

    public void setFieldsOfStudy(List<FieldOfStudy> fieldsOfStudy) {
        this.fieldsOfStudy = fieldsOfStudy;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setId(int id){
        this.id = UUID.fromString(Integer.toString(id));
    }

    @Override
    public String toString(){
        return "University";
    }
}
