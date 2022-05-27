package trailProject.trail.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trailProject.trail.config.Result;
import trailProject.trail.config.StatusEnum;
import trailProject.trail.history.dto.save.HistoryDto;
import trailProject.trail.history.dto.view.HistoryViewDto;
import trailProject.trail.history.entity.History;
import trailProject.trail.history.service.HistoryService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/trail")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @PostMapping("/user/courseSave")
    public Result<String> saveHistory(@RequestBody HistoryDto historyDto){
        historyService.saveHistory(historyDto);
        return Result.res(StatusEnum.OK, "히스토리가 저장됐습니다.", "ok");
    }

    @GetMapping("/user/history/view")
    public Result<Page<HistoryViewDto>> viewHistory(Pageable pageable){
        Page<History> histories = historyService.viewHistory(pageable);
        Page<HistoryViewDto> historyViewDtos = histories
                .map(history -> new HistoryViewDto(history));
        return Result.res(StatusEnum.OK, "히스토리 조회", "ok", historyViewDtos);
    }
}