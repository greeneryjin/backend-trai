package trailProject.trail.course.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long id;
    private String courseName;
    private String courseAddress;
    private Integer courseDistance;
    private Integer level;

    public CourseDto(Long id, String courseName, String courseAddress, Integer courseDistance, Integer level) {
        this.id = id;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
    }

}
