package trailProject.trail.course.dto;

import lombok.Data;

@Data
public class CoordinateDto {
    private String y;
    private String x;

    public CoordinateDto(String y, String x) {
        this.y = y;
        this.x = x;
    }
}
