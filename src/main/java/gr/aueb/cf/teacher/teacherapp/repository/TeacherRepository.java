package gr.aueb.cf.teacher.teacherapp.repository;

import gr.aueb.cf.teacher.teacherapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JpaSpecificationExecutor<T> είναι ένα interface που
 * μας δίνει την δυνατότητα να κάνουμε filtering με
 * Criteria API
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
    List<Teacher> findByRegionId(Long id);
    Optional<Teacher> findByUuid(String uuid);
    Optional<Teacher> findByVat(String vat);

}
