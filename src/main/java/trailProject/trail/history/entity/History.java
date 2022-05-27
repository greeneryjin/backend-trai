package trailProject.trail.history.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import trailProject.trail.account.entity.Account;
import trailProject.trail.history.dto.save.HistoryDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    private String courseName;
    private LocalDateTime workStartTime;
    private LocalDateTime workFinishTime;
    private Integer distance;

    //private Boolean workComplete;
    private String courseAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public void saveAccount(Account account){
        this.account = account;
    }

    public void saveHistory(HistoryDto historyDto) {
        this.courseName = historyDto.getCourseName();
        //this.workComplete = historyDto.getWorkComplete();
        this.workStartTime = historyDto.getWorkStartTime();
        this.distance = historyDto.getDistance();
        this.workFinishTime = historyDto.getWorkFinishTime();
        this.courseAddress = historyDto.getCourseAddress();
    }
}