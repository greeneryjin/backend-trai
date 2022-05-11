package trailProject.trail.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<CourseDto> findByCourseAddressContains(String courseAddress);

    CourseDto findByCourseId(Long courseId);

//    @Query("select new trailProject.trail.course.dto.CourseDto(c.courseId, c.courseName, c.courseAddress, c.courseDistance, c.level) from Course c")
//    List<CourseDto> findCourseDto();
}