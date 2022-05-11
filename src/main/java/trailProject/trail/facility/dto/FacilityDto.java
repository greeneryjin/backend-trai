package trailProject.trail.facility.dto;

import lombok.Data;

@Data
public class FacilityDto {
    private Long facilityId;
    private String facilityName;
    private String x;
    private String y;

    public FacilityDto(Long facilityId, String facilityName, String x, String y) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.x = x;
        this.y = y;
    }
}
