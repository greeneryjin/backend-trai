package trailProject.trail.security.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import trailProject.trail.account.entity.Account;

import java.util.Collection;

//인증을 위한 객체 생성.

@Getter
public class AccountContext extends User {

    private Account account;

    public AccountContext(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(String.valueOf(account.getId()), account.getName(), authorities);
        this.account = account;
    }

    public Long getId(){
        return account.getId();
    }
}
