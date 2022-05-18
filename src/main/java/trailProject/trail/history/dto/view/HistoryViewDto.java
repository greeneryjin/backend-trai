package trailProject.trail.history.dto.view;

import  lombok.Getter;
import lombok.Setter;
import trailProject.trail.history.entity.History;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryViewDto {
    private String courseName;
    private LocalDateTime workStartTime;
    private Integer distance;
    private Boolean workComplete;
    private String CourseAddress;

    public HistoryViewDto(History history) {
        this.workStartTime = history.getWorkStartTime();
        this.distance = history.getDistance();
        this.workComplete = history.getWorkComplete();
        this.courseName = history.getCourseName();
        this.CourseAddress = history.getCourseAddress();
    }
}
