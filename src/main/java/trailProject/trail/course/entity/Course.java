package trailProject.trail.course.entity;

import trailProject.trail.account.entity.Account;

import javax.persistence.*;

@Entity
public class Course { //controller 할 때 /trail 붙이기

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
