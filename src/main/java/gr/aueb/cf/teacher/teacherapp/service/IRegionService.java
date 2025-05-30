package gr.aueb.cf.teacher.teacherapp.service;

import gr.aueb.cf.teacher.teacherapp.model.static_data.Region;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRegionService {
    List<Region> findAllRegions();
}
