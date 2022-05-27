package trailProject.trail.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import trailProject.trail.history.entity.History;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    private String snsId;
    private String name;
    private String roles;
    private String location;

    private Integer distanceTotal;
    private LocalDate timeTotal;
    private Integer workDistance;
    private LocalDate workDate;

    public Account(String snsId, String name) {
        this.snsId = snsId;
        this.name = name;
    }

    public void roleSave(String role){
        this.roles = role;
    }
}