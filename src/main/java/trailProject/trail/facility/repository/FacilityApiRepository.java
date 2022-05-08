package trailProject.trail.facility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trailProject.trail.facility.entity.FacilityApi;

@Repository
public interface FacilityApiRepository extends JpaRepository<FacilityApi, Long> {
}
