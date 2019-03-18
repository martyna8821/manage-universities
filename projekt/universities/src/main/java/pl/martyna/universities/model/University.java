package pl.martyna.universities.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "university")
@Getter @Setter
//@EntityListeners(AuditingEntityListener.class)
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


}
