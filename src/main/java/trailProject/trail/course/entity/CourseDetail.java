package trailProject.trail.course.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CourseDetail {
    @Id @GeneratedValue
    @Column(name="courseDetail_id")
    private Long id;

    private String x;
    private String y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;
}
