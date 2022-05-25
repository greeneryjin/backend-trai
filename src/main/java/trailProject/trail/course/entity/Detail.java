package trailProject.trail.course.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import trailProject.trail.course.entity.Course;
import trailProject.trail.facility.entity.Facility;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Detail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;

    @Lob
    private String coordinateArray;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;

    @OneToMany(mappedBy = "detail")
    private List<Facility> facilities = new ArrayList<>();

    public Detail(Long id, String coordinateArray) {
        this.detailId = id;
        this.coordinateArray = coordinateArray;
    }
}
