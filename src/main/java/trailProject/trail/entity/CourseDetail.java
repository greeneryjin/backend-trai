package trailProject.trail.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="course_detail")
public class CourseDetail {
    @Id @GeneratedValue
    @Column(name="course_detail_id")
    private Long id;

    private String coordinateArray;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;
}
