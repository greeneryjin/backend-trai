package trailProject.trail.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.entity.enums.Role;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.security.user.AccountContext;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtAccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        long userId = Long.parseLong(id);
        Account account = accountRepository.findAccountById(userId);

        if(account == null){
            throw new UsernameNotFoundException("유저 정보가 디비에 없습니다.");
        }
        //어드민 권한이면 ROLE_ADMIN 권한을 주고 반환.
        String admin = Role.ADMIN.getGrantedAuthority();
        if(account.getRoles().equals(admin)){
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            AccountContext accountContext = new AccountContext(account, roles);
            return accountContext;
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        AccountContext accountContext = new AccountContext(account, roles);
        return accountContext;
    }
}
