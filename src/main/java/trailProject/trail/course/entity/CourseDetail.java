package trailProject.trail.course.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import trailProject.trail.course.entity.Course;
import javax.persistence.*;

@Data
@Entity
@Table(name="course_detail")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseDetailId;

    @Lob
    private String coordinateArray;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;

    public CourseDetail(Long id, String coordinateArray) {
        this.courseDetailId = id;
        this.coordinateArray = coordinateArray;
    }
}