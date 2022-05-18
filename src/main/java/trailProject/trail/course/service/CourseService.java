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

import java.util.ArrayList;
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

    public List<String> findCourseGu() {
        List<Course> courseList = courseRepository.findAll();
        List<String> guList = new ArrayList<>();

        for(Course course : courseList) {
            int si = course.getCourseAddress().indexOf('시');
            int gu = course.getCourseAddress().indexOf('구');
            String str = course.getCourseAddress().substring(si+1, gu+1);
            if(!guList.contains(str)) {
                guList.add(str);
            }
        }
        return guList;
    }
}
