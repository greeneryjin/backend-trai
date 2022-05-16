package trailProject.trail.course.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.account.service.AccountService;
import trailProject.trail.course.dto.CourseDetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.CourseDetail;
import trailProject.trail.course.service.CourseService;
import java.util.List;

@RestController
@RequestMapping("/trail")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courseList")
    public List<CourseDto> courseList(@RequestParam String courseAddress) {
        List<CourseDto> courses = courseService.findCourseByCourseAddress(courseAddress);
        return courses;
    }

    @GetMapping("/courseStart")
    public CourseDetailDto courseStart(@RequestParam Long courseId) {
        CourseDetailDto courseDetail = courseService.findCourseDetailByCourseId(courseId);
        return courseDetail;
    }
}
