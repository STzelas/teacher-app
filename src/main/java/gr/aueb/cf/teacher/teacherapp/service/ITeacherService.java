package gr.aueb.cf.teacher.teacherapp.service;

import gr.aueb.cf.teacher.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacher.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacher.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacher.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacher.teacherapp.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface ITeacherService {

    Teacher saveTeacher(TeacherInsertDTO dto)
            throws EntityAlreadyExistsException, EntityInvalidArgumentException;
    Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size);
}
