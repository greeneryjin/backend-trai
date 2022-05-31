package trailProject.trail.course.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.config.Result;
import trailProject.trail.config.StatusEnum;
import trailProject.trail.course.dto.DetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.service.CourseService;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/trail")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/course")
    public Result<List<CourseDto>> courseList(@RequestParam String level,
                                              @RequestParam String toilet,
                                              @RequestParam String charge,
                                              @RequestParam String thirtyMore) {

        //사용자 location 가지고 와서 gu로 사용
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();
        Account account = accountRepository.findBySnsId(accountId.getSnsId());
        String gu = account.getLocation();

        List<CourseDto> courses = courseService.findByFilter(gu, level, toilet, charge, thirtyMore);
        return Result.res(StatusEnum.OK, "검색한 구의 코스리스트", "success", courses);
    }

    @GetMapping("/detail")
    public Result<DetailDto> courseStart(@RequestParam Long courseId) {
        DetailDto detailDto = courseService.findDetailByCourseId(courseId);
        return Result.res(StatusEnum.OK, "선택한 코스 경로", "success", detailDto);
    }

    @GetMapping("/address")
    public Result<List<String>> courseGu() {
        List<String> guList = courseService.findCourseGu();
        return Result.res(StatusEnum.OK, "코스가 존재하는 구", "success", guList);

    }
}