package gr.aueb.cf.teacher.teacherapp.repository;

import gr.aueb.cf.teacher.teacherapp.core.enums.Role;
import gr.aueb.cf.teacher.teacherapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
    Long countByRole(Role role);
}
