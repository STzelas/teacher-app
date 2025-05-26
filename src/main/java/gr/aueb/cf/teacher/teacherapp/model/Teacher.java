package gr.aueb.cf.teacher.teacherapp.model;

import gr.aueb.cf.teacher.teacherapp.model.static_data.Region;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
public class Teacher extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
    private Long id;

    @Column(unique = true)  // name είναι το ίδιο του πεδίου
    private String uuid;

    @Column(unique = true)
    private String vat;

    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @PrePersist
    public void initializeUUID () {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
