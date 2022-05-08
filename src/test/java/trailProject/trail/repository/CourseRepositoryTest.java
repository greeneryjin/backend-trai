package trailProject.trail.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.repository.CourseRepository;

import java.util.List;

@SpringBootTest
@Transactional
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findCourseDto() {
        Course c1 = new Course(1L, "AAA", "BBB", "2", "3");
        courseRepository.save(c1);

        List<CourseDto> courseDto = courseRepository.findCourseDto();
        for (CourseDto dto : courseDto) {
            System.out.println("dto = " + dto);
        }
    }
}