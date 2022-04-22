package trailProject.trail.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.security.user.AccountContext;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account saveAccount(Account accountSave) {
       return accountRepository.save(accountSave);
    }

    public List<Account> findAll() {
        List<Account> all = accountRepository.findAll();
        return all;
    }
}
