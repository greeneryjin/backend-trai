package trailProject.trail.course.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.account.service.AccountService;
import trailProject.trail.config.Result;
import trailProject.trail.config.StatusEnum;
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
    public Result<List<CourseDto>> courseList(@RequestParam String courseAddress) {
        List<CourseDto> courses = courseService.findCourseByCourseAddress(courseAddress);
        return Result.res(StatusEnum.OK, "검색한 구의 코스리스트", "success", courses);
    }

    @GetMapping("/courseStart")
    public Result<CourseDetailDto> courseStart(@RequestParam Long courseId) {
        CourseDetailDto courseDetail = courseService.findCourseDetailByCourseId(courseId);
        return Result.res(StatusEnum.OK, "선택한 코스 경로", "success", courseDetail);
    }

    @GetMapping("/courseGu")
    public Result<List<String>> courseGu() {
        List<String> guList = courseService.findCourseGu();
        return Result.res(StatusEnum.OK, "코스가 존재하는 구", "success", guList);
    }
}
