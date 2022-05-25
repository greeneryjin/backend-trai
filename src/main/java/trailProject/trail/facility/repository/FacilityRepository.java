package trailProject.trail.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.course.entity.Detail;
import trailProject.trail.facility.entity.Facility;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    List<Facility> findByDetail(Detail detail);

}
