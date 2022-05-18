package trailProject.trail.course.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long courseId;
    private String courseName;
    private String courseAddress;
    private String courseDistance;
    private String level;
    private String time;

    public CourseDto(Long courseId, String courseName, String courseAddress, String courseDistance, String level, String time) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
        this.time = time;
    }
}
