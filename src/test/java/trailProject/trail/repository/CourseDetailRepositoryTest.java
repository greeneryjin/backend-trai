package trailProject.trail.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trailProject.trail.course.dto.CourseDetailDto;
import trailProject.trail.course.entity.CourseDetail;
import trailProject.trail.course.repository.CourseDetailRepository;

import java.util.List;

@SpringBootTest
@Transactional
class CourseDetailRepositoryTest {
    @Autowired
    CourseDetailRepository courseDetailRepository;

    @Test
    public void findCourseDetailDtoTest() {
        courseDetailRepository.save(new CourseDetail(1L, "[[1,1],[2,2],[3,3]]"));
        courseDetailRepository.save(new CourseDetail(2L, "[[2,2],[4,4],[6,6]]"));

        List<CourseDetailDto> courseDetailDtoList = courseDetailRepository.findCourseDetailDto();
        for (CourseDetailDto courseDetailDto : courseDetailDtoList) {
            System.out.println("courseDetailDto = " + courseDetailDto);
        }
    }
}