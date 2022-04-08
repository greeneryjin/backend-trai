package trailProject.trail.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.repository.CourseRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    //구 단위로 코스 리스트 보여주는거
    public List<Course> findByCourseAddress(String courseAddress) {
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Course> page = courseRepository.findByCourseAddress(courseAddress, pageRequest);
        return page.getContent();
    }
}
