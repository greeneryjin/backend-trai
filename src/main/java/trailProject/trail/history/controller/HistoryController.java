package trailProject.trail.history.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trailProject.trail.config.Result;
import trailProject.trail.config.StatusEnum;
import trailProject.trail.history.dto.save.HistoryDto;
import trailProject.trail.history.service.HistoryService;

@RestController
@RequestMapping("/trail")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @PostMapping("/user/history/save")
    public Result<String> saveHistory(@RequestBody HistoryDto historyDto){
        historyService.saveHistory(historyDto);
        return Result.res(StatusEnum.OK, "히스토리가 저장됐습니다.", "ok");
    }
}
