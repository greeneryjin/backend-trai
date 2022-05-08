package trailProject.trail.facility.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.Type;

import javax.persistence.*;

@Entity
@Data
@Table(name="facility")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Facility {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Facility_id")
    private Long facilityId;
    private String facilityName;
    private String x;
    private String y;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;

    public Facility(Long facilityId, String facilityName, String x, String y) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.x = x;
        this.y = y;
    }
}

