package trailProject.trail.history.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import trailProject.trail.account.entity.Account;
import trailProject.trail.history.dto.save.HistoryDto;

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

    public void saveAccount(Account account){
        this.account = account;
    }

    public void saveHistory(HistoryDto historyDto) {
        this.workComplete = historyDto.getWorkComplete();
        this.workTime = historyDto.getWorkTime();
        this.distance = historyDto.getDistance();
        this.workDate = historyDto.getWorkDate();
    }
}


