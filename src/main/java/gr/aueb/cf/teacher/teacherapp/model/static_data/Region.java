package gr.aueb.cf.teacher.teacherapp.model.static_data;

import gr.aueb.cf.teacher.teacherapp.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Αν δεν κάνω new HashSet το hibernate κάνει σε δικό του collection
    // Θέλουμε HashSet και όχι ArrayList επειδή έχουν πιο γρήγορους
    // χρόνους αναζήτησης + δεν επιτρέπουν duplicates (Ο(1))

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "region")
    private Set<Teacher> teachers = new HashSet<>();

    public Set<Teacher> getAllTeachers() {
        if (teachers == null) teachers = new HashSet<>();
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setRegion(this);
    }
}
