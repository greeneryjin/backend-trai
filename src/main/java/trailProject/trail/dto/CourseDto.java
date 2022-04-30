package trailProject.trail.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long courseId;
    private String courseName;
    private String courseAddress;
    private Integer courseDistance;
    private Integer level;

    public CourseDto(Long courseId, String courseName, String courseAddress, Integer courseDistance, Integer level) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
    }

}
