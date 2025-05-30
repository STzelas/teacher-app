package gr.aueb.cf.teacher.teacherapp.service;

import gr.aueb.cf.teacher.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacher.teacherapp.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService implements IRegionService{

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findAll();
    }
}
