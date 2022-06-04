package trailProject.trail.course.dto;

import lombok.Data;
import trailProject.trail.facility.dto.FacilityDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DetailDto {
    private Long courseDetailId;
    //private Map<String, String> coordinateArray;
    private ArrayList<CoordinateDto> coordinateArray;
    private List<FacilityDto> facilityDtoList;

    public DetailDto(Long courseDetailId, ArrayList<CoordinateDto> coordinateArray) { //Map<String, String> coordinateArray) {
        this.courseDetailId = courseDetailId;
        this.coordinateArray = coordinateArray;
    }
}