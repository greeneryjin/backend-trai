package trailProject.trail.facility.dto;

import lombok.Data;
import trailProject.trail.facility.entity.Type;

import java.util.Map;

@Data
public class FacilityDto {
    private Long facilityId;
    private String facilityName;
    private Type type;
    private Map<String, String> coordinate;

    public FacilityDto(Long facilityId, String facilityName, Type type, Map<String, String> coordinate) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.type = type;
        this.coordinate = coordinate;
    }
}
