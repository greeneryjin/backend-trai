package trailProject.trail.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByCourseId(Long courseId);

    List<CourseDto> findByGu(String gu);

    List<CourseDto> findByGuAndThirtyMore(String gu, String thirtyMore);

    List<CourseDto> findByGuAndCharge(String gu, String charge);

    List<CourseDto> findByGuAndChargeAndThirtyMore(String gu, String charge, String thirtyMore);

    List<CourseDto> findByGuAndToilet(String gu, String toilet);

    List<CourseDto> findByGuAndToiletAndThirtyMore(String gu, String toilet, String thirtyMore);

    List<CourseDto> findByGuAndToiletAndCharge(String gu, String toilet, String charge);

    List<CourseDto> findByGuAndToiletAndChargeAndThirtyMore(String gu, String toilet, String charge, String thirtyMore);

    List<CourseDto> findByGuAndLevel(String gu, String level);

    List<CourseDto> findByGuAndLevelAndThirtyMore(String gu, String level, String thirtyMore);

    List<CourseDto> findByGuAndLevelAndCharge(String gu, String level, String charge);

    List<CourseDto> findByGuAndLevelAndChargeAndThirtyMore(String gu, String level, String charge, String thirtyMore);

    List<CourseDto> findByGuAndLevelAndToilet(String gu, String level, String toilet);

    List<CourseDto> findByGuAndLevelAndToiletAndThirtyMore(String gu, String level, String toilet, String thirtyMore);

    List<CourseDto> findByGuAndLevelAndToiletAndCharge(String gu, String level, String toilet, String charge);

    List<CourseDto> findByGuAndLevelAndToiletAndChargeAndThirtyMore(String Gu, String level, String toilet, String charge, String thirtyMore);


//    @Query("select new trailProject.trail.course.dto.CourseDto(c.courseId, c.courseName, c.courseAddress, c.courseDistance, c.level) from Course c")
//    List<CourseDto> findCourseDto();
}