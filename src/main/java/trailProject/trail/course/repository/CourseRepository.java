package trailProject.trail.course.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByCourseAddress(String courseAddress, Pageable pageable);

    @Query("select new trailProject.trail.course.dto.CourseDto(c.id, c.courseName, c.courseAddress, c.courseDistance, c.level) from Course c")
    List<CourseDto> findCourseDto();

}