package trailProject.trail.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name="facility_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "type"})
public class FacilityDetail {

    @Id @GeneratedValue
    @Column(name="Facility_Detail_id")
    private Long id;

    private String x;
    private String y;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;
}

