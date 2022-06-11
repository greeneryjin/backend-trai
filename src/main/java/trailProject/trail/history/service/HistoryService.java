package trailProject.trail.history.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.history.dto.save.HistoryDto;
import trailProject.trail.history.entity.History;
import trailProject.trail.history.repository.HistoryRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    AccountRepository accountRepository;

    @Transactional(readOnly = false)
    public void saveHistory(HistoryDto historyDto) {

        //사용자 가지고 오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();
        Account account = accountRepository.findBySnsId(accountId.getSnsId());

        //히스토리 저장
        History history = new History();
        history.saveAccount(account);
        history.saveHistory(historyDto);
        historyRepository.save(history);

        LocalDateTime workFinishTime = historyDto.getWorkFinishTime();
        LocalDate localDate = LocalDate.now();
        LocalDate workFinish = LocalDate.from(workFinishTime);
        Period between = Period.between(workFinish, localDate);
        int days = between.getDays();

        int distance;
        int step;
        int time;

        if(account.getDistanceTotal() == null && account.getStepCountTotal() == null && account.getTimeTotal() == null) {
            distance = historyDto.getDistance();
            step = historyDto.getStepCount();
            time = historyDto.getWorkTime();
        }
        else {
            distance = account.getDistanceTotal() + historyDto.getDistance();
            step = account.getStepCountTotal() + historyDto.getStepCount();
            time = account.getTimeTotal() + historyDto.getWorkTime();
        }
        account.saveWork(distance, step, time, days);
    }

    @Transactional(readOnly = true)
    public Page<History> viewHistory(Pageable pageable) {

        //사용자 가지고 오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();
        Account account = accountRepository.findBySnsId(accountId.getSnsId());

        Page<History> historyPage = historyRepository.findAllByAccountId(pageable, account.getId());
        return historyPage;
    }
}