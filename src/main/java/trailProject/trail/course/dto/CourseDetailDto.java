package trailProject.trail.course.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CourseDetailDto {
    private Long courseDetailId;
    private Map<String, String> coordinateArray;

    public CourseDetailDto(Long courseDetailId, Map<String, String> coordinateArray) {
        this.courseDetailId = courseDetailId;
        this.coordinateArray = coordinateArray;
    }
}
