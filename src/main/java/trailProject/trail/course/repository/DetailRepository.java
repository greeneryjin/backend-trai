package trailProject.trail.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    Detail findByCourse(Course course);

}
