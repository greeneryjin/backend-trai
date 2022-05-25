package trailProject.trail.facility.dto;

import lombok.Data;

import java.util.Map;

@Data
public class FacilityDto {
    private Long facilityId;
    private String facilityName;
    private Map<String, String> coordinate;

    public FacilityDto(Long facilityId, String facilityName, Map<String, String> coordinate) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.coordinate = coordinate;
    }
}
