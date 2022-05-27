package trailProject.trail.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trailProject.trail.account.dto.LoginDto;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.entity.enums.Role;
import trailProject.trail.account.service.AccountService;
import trailProject.trail.config.Result;
import trailProject.trail.config.StatusEnum;

import java.util.List;

@RestController
@RequestMapping("/trail")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //회원가입
    @PostMapping("/signUp")
    public Result<Long> signUpAccount(@RequestBody LoginDto loginDto){
        String user = Role.USER.getGrantedAuthority();
        Account account = new Account(loginDto.getSnsId(), loginDto.getName());
        account.roleSave(user);
        Account saveAccount = accountService.saveAccount(account);
        return Result.res(StatusEnum.OK, "회원가입이 완료되었습니다.", "success", saveAccount.getId());
    }

    //로그인
    @PostMapping("/signIn")
    public void signInAccount(){ }

    //인가 확인
    @GetMapping("/users")
    public Result<List<Account>> allUsers(){
        return Result.res(StatusEnum.OK, "회원이 조회됐습니다.", "success", this.accountService.findAll());
    }
//    @GetMapping("/user/view/mypage")
//    public Result<Account> userPage() {
//        accountService.findUser();
//    }
}