package trailProject.trail.history.dto.save;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryDto {

    private LocalDateTime workTime;
    private LocalDate workDate;
    private Integer distance;
    private Boolean workComplete;
}
