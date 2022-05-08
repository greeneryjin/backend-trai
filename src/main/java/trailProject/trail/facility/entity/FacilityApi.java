package trailProject.trail.facility.entity;

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
public class FacilityApi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String COT_COORD_Y;
    private String COT_CONTS_NAME;
    private String DIST;
    private String COT_NATION_POINT_NUMBER;
    private String COT_NATION_BASE_AREA;
    private String COT_TEL_NO;
    private String COT_CONTS_STAT;
    private String COT_VALUE_01;
    private String COT_COORD_X;
    private String COT_DONG_NAME;
    private String COT_REG_DATE;
    private String COT_EXTRA_NAME;
    private String COT_COORD_DATA;
    private String COT_MBR_MIN_X;
    private String THM_THEME_NAME;
    private String COT_MBR_MIN_Y;
    private String COT_CONTS_ID;
    private String COT_CONTS_LAN_TYPE;
    private String COT_SAN_NAME;
    private String COT_LINE_PATTERN;
    private String THM_THEME_TYPE;
    private String COT_LINE_COLOR;
    private String THM_COORD_TYPE;
    private String COT_UPDATE_DATE;
    private String COT_MBR_MAX_X;
    private String COT_THEME_ID;
    private String COT_MBR_MAX_Y;
    private String COT_EXTRA_DATA_01;
    private String COT_IMG_MAIN_URL;
    private String COT_GU_NAME;
    private String COT_LINE_WEIGHT;
    private String COT_THEME_SUB_ID;
    private String COT_SLAVE_NO;
    private String RNUM;
    private String COT_ADDR_FULL_NEW;
    private String COT_KW;
    private String COT_COORD_TYPE;
    private String COT_ADDR_FULL_OLD;
    private String COT_MASTER_NO;
}
