package trailProject.trail.history.dto.view;

import  lombok.Getter;
import lombok.Setter;
import trailProject.trail.history.entity.History;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class HistoryViewDto {
    private String courseName;
    private String workStartTime;
    private Integer distance;
    private Boolean workComplete;
    private String CourseAddress;

    public HistoryViewDto(History history) {
        this.workStartTime = changeTimeFormat(history.getWorkStartTime());
        this.distance = history.getDistance();
        //this.workComplete = history.getWorkComplete();
        this.courseName = history.getCourseName();
        this.CourseAddress = history.getCourseAddress();
    }

    public String changeTimeFormat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        String formatted = localDateTime.format(formatter);
        return formatted;
    }
}