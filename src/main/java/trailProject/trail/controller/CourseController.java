package trailProject.trail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trailProject.trail.dto.CourseDto;
import trailProject.trail.service.CourseService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trail")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/course/list")
    public void courseList(String courseAddress) {
        List<CourseDto> courses = courseService.findByCourseAddress(courseAddress);
        for(CourseDto coursedto : courses){
            System.out.println(coursedto.getCourseName());
        }
    }

//    @GetMapping("/course/start")
//    public String courseStart(Long account_id) {
//        return "";
//    }

}
