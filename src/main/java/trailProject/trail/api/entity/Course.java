package trailProject.trail.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double COURSE_CATEGORY;
    private String COURSE_CATEGORY_NM;
    private String SOUTH_NORTH_DIV;
    private String SOUTH_NORTH_DIV_NM;
    private String AREA_GU;
    private String DISTANCE;
    private String LEAD_TIME;
    private String COURSE_LEVEL;
    private double VOTE_CNT;
    private String RELATE_SUBWAY;
    private String TRAFFIC_INFO;
    private String CONTENT;
    private String PDF_FILE_PATH;
    private String COURSE_NAME;
    private String REG_DATE;
    private String DETAIL_COURSE;
    private double CPI_IDX;
    private String CPI_NAME;
    private String X;
    private String Y;
}
