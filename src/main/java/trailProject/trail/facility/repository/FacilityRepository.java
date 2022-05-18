package trailProject.trail.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trailProject.trail.facility.dto.FacilityDto;
import trailProject.trail.facility.entity.Facility;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Query("select new trailProject.trail.facility.dto.FacilityDto(f.facilityId, f.facilityName, f.x, f.y) from Facility f")
    List<FacilityDto> facilityDtoBy();
}
