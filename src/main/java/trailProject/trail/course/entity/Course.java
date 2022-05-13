package trailProject.trail.course.entity;
import lombok.*;
import trailProject.trail.facility.entity.Facility;
import javax.persistence.*;
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
    private String courseAddress;
    private String courseDistance;
    private String level;
    private String time;

    @OneToMany(mappedBy = "course")
    private List<Facility> facilities = new ArrayList<>();

    //    @OneToMany(mappedBy = "course")
    //    private List<CourseDetail> courseDetails = new ArrayList<>();

    public Course(Long id, String courseName, String courseAddress, String courseDistance, String level) {
        this.courseId = id;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
    }

}
