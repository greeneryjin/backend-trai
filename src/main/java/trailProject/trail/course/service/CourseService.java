package trailProject.trail.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trailProject.trail.course.dto.CourseDetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.CourseDetail;
import trailProject.trail.course.repository.CourseDetailRepository;
import trailProject.trail.course.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final CourseDetailRepository courseDetailRepository;

    public List<CourseDto> findCourseByCourseAddress(String courseAddress) {
        List<CourseDto> courseDtoList = courseRepository.findByCourseAddressContains(courseAddress);
        return courseDtoList;
    }

    public CourseDetailDto findCourseDetailByCourseId(Long courseId) {
        CourseDetailDto courseDetail = courseDetailRepository.findByCourseDetailId(courseId);
        return courseDetail;
    }
}
