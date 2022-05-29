package trailProject.trail.course.dto;

import lombok.Data;
import trailProject.trail.facility.dto.FacilityDto;

import java.util.List;
import java.util.Map;

@Data
public class DetailDto {
    private Long courseDetailId;
    private Map<String, String> coordinateArray;
    private List<FacilityDto> facilityDtoList;

    public DetailDto(Long courseDetailId, Map<String, String> coordinateArray) {
        this.courseDetailId = courseDetailId;
        this.coordinateArray = coordinateArray;
    }
}