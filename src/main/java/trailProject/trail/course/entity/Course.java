package trailProject.trail.course.entity;

import lombok.*;
import trailProject.trail.member.Account;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long id;

    private String courseName;
    private LocalDateTime time;
    private String courseAddress;
    private Integer courseDistance;
    private Integer level;

    @OneToMany(mappedBy = "course")
    private List<FacilityDetail> facilityDetails = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<CourseDetail> courseDetails = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")
    private Account account;

    public Course(Long id, String courseName, String courseAddress, Integer courseDistance, Integer level) {
        this.id = id;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.courseDistance = courseDistance;
        this.level = level;
    }
}
