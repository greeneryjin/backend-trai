package trailProject.trail.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView indexView() {
        ModelAndView model = new ModelAndView("trail/index");
        return model;
    }
}
