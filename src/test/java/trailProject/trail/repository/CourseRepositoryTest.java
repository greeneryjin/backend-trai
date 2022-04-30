package trailProject.trail.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import trailProject.trail.dto.CourseDto;
import trailProject.trail.entity.Course;
import java.util.List;

@SpringBootTest
@Transactional
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findCourseDtoTest() {
        courseRepository.save(new Course(1L, "AAA", "BBB", 2, 3));

        List<CourseDto> courseDto = courseRepository.findCourseDto();
        for (CourseDto dto : courseDto) {
            System.out.println("dto = " + dto);
        }
    }

    @Test
    public void findByCourseAddressTest() {
        courseRepository.save(new Course(1L, "AAA", "FFF", 1, 1));
        courseRepository.save(new Course(2L, "BBB", "GGG", 2, 2));
        courseRepository.save(new Course(3L, "CCC", "GGG", 3, 3));
        courseRepository.save(new Course(4L, "DDD", "HHH", 4, 4));
        courseRepository.save(new Course(5L, "EEE", "HHH", 5, 5));

        String courseAddress = "HHH";
        PageRequest pageRequest = PageRequest.of(0,5, Sort.by(Sort.Direction.DESC, "courseAddress"));

        Page<CourseDto> page = courseRepository.findByCourseAddress(courseAddress, pageRequest);

        List<CourseDto> content = page.getContent();
        long totalElements = page.getTotalElements();
        for (CourseDto courseDto : content) {
            System.out.println("course = " + courseDto);
        }
        System.out.println("totalElements = " + totalElements);
    }
}