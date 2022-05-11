package trailProject.trail.history.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import trailProject.trail.account.entity.Account;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    private LocalDateTime workTime;
    private LocalDate workDate;
    private Integer distance;
    private Boolean workComplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}