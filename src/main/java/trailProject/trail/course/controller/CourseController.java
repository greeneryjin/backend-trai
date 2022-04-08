package trailProject.trail.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trail")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/course/list")
    public void courseList(String courseAddress) {
        List<Course> courses = courseService.findByCourseAddress(courseAddress);
        for(Course course : courses){
            System.out.println(course.getCourseName());
        }
    }

    @GetMapping("/course/start")
    public String courseStart(Long userId) {
        return "";
    }

    @PostMapping("/course/finish")
    public String courseFinish() {
        return "";
    }


}
