package trailProject.trail.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.api.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
