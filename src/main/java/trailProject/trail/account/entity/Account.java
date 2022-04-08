package trailProject.trail.account.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String name;

    private Integer distanceTotal;
    private LocalDate timeTotal;
    private String roles;
}
