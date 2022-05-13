package trailProject.trail.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trailProject.trail.course.dto.CourseDetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.CourseDetail;

import java.util.List;

public interface CourseDetailRepository extends JpaRepository<CourseDetail, Long> {
    CourseDetail findByCourseDetailId(Long id);

}
