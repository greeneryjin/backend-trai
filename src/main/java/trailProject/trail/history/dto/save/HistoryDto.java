package trailProject.trail.history.dto.save;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

@Getter
@Setter
public class HistoryDto {

    private String courseName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime workStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime workFinishTime;
    private String courseAddress;

    private Integer distance;
    private Integer stepCount;
    private Integer workTime;
    //private Boolean workComplete;
}