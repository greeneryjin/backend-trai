package trailProject.trail.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Integer distanceTotal;
    private LocalDate timeTotal;
    private String roles;

    public Account(String snsId, String name) {
        this.snsId = snsId;
        this.name = name;
    }

    public void roleSave(String role){
        this.roles = role;
    }

}