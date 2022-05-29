package trailProject.trail.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.course.repository.CourseRepository;
import trailProject.trail.history.repository.HistoryRepository;
import trailProject.trail.security.user.AccountContext;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    HistoryRepository historyRepository;

    public Account saveAccount(Account accountSave) {
        return accountRepository.save(accountSave);
    }

    public Account findUser() {
        //사용자 가지고 오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();
        Account account = accountRepository.findBySnsId(accountId.getSnsId());
        return account;
    }

    public Account saveLocation(String location) {
        //사용자 가지고 오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account accountId = (Account) authentication.getPrincipal();
        Account account = accountRepository.findBySnsId(accountId.getSnsId());

        account.locationSave(location);
        return account;
    }
}