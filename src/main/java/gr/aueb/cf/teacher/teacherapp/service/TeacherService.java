package gr.aueb.cf.teacher.teacherapp.service;

import gr.aueb.cf.teacher.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacher.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacher.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacher.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacher.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacher.teacherapp.model.Teacher;
import gr.aueb.cf.teacher.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacher.teacherapp.repository.RegionRepository;
import gr.aueb.cf.teacher.teacherapp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor // Constructor των final πεδίων. Σαν αυτό που έκανα κάτω μπορώ και ετσι με lombok
public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;
    private final Mapper mapper;

    @Autowired // Σαν το @Inject της jakarta (DI)
    public TeacherService(TeacherRepository teacherRepository, RegionRepository regionRepository, Mapper mapper) {
        this.teacherRepository = teacherRepository;
        this.regionRepository = regionRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Teacher saveTeacher(TeacherInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException {
        if (teacherRepository.findByVat(dto.getVat()).isPresent()) {
            throw new EntityAlreadyExistsException("Teacher", "Teacher with vat " + dto.getVat() + " already exists.");
        }

        Teacher teacher = mapper.mapToTeacherEntity(dto);

        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new EntityInvalidArgumentException("Region", "Invalid region id"));

       region.addTeacher(teacher);

       // Επιστρέφει το αλλαγμένο Entity / return τον updatedTeacher στην ουσία
       return teacherRepository.save(teacher);

    }

    @Override
    @Transactional
    public Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> teacherPage = teacherRepository.findAll(pageable);

        return teacherPage.map(mapper::mapToTeacherReadOnlyDTO);
    }


}
