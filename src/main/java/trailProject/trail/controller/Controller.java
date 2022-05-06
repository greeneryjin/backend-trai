package trailProject.trail.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trail")
public class Controller {

    @GetMapping("/test/vise")
    public String viewTest() {
        return "화면 테스트 성공";
    }

}
