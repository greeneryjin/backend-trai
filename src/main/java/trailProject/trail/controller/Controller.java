package trailProject.trail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trail")
public class Controller {

    @GetMapping("/test/vise")
    public String viewTest() {
        return "화면 테스트 성공";
    }
}
