package trailProject.trail.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name="course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;
    private LocalDateTime time;
    private String courseAddress;
    private Integer courseDistance;
    private Integer level;

    @OneToMany(mappedBy = "course")
    private List<FacilityDetail> facilityDetails = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<CourseDetail> courseDetails = new ArrayList<>();

    public Course(Long id, String courseName, String courseAddress, Integer courseDistance, Integer level) {
        this.courseId = id;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
    }

}
