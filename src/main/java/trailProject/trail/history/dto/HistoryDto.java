package trailProject.trail.history.dto.save;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryDto {

    private String courseName;
    private LocalDateTime workStartTime;
    private LocalDateTime workFinishTime;
    private Integer distance;
    private Boolean workComplete;
    private String CourseAddress;
}