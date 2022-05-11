package trailProject.trail.course.dto;

import lombok.Data;

@Data
public class CourseDetailDto {
    private Long courseDetailId;
    private String coordinateArray;

    public CourseDetailDto(Long courseDetailId, String coordinateArray) {
        this.courseDetailId = courseDetailId;
        this.coordinateArray = coordinateArray;
    }
}
