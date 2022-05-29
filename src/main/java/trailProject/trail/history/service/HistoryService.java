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
import java.time.temporal.ChronoUnit;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    AccountRepository accountRepository;

    @Transactional
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
        long lastWorkDate = workFinish.until(localDate, ChronoUnit.DAYS);

        int distance = account.getDistanceTotal() + historyDto.getDistance();
        int step = account.getStepCountTotal() + historyDto.getStepCount();
        int time = account.getTimeTotal() + historyDto.getWorkTime();

        //사용자 운동 저장
        account.saveWork(distance, step, time, lastWorkDate);
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