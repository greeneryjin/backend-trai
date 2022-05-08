package trailProject.trail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import trailProject.trail.dto.CourseDto;
import trailProject.trail.course.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<CourseDto> findByCourseAddress(String courseAddress, Pageable pageable);

    CourseDto findByCourseId(Long courseId);

    @Query("select new trailProject.trail.dto.CourseDto(c.courseId, c.courseName, c.courseAddress, c.courseDistance, c.level) from Course c")
    List<CourseDto> findCourseDto();

}