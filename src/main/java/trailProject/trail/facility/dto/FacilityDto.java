package trailProject.trail.facility.dto;

import lombok.Data;
import trailProject.trail.course.dto.CoordinateDto;
import trailProject.trail.facility.entity.Type;

import java.util.ArrayList;
import java.util.Map;

@Data
public class FacilityDto {
    private Long facilityId;
    private String facilityName;
    private Type type;
//    private Map<String, String> coordinate;
    private CoordinateDto coordinate;

    public FacilityDto(Long facilityId, String facilityName, Type type, CoordinateDto coordinate) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.type = type;
        this.coordinate = coordinate;
    }
}
