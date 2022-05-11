package trailProject.trail.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import trailProject.trail.security.service.JwtAccountService;
import trailProject.trail.security.token.JwtUsernamePasswordAuthenticationToken;
import trailProject.trail.security.user.AccountContext;

public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    JwtAccountService jwtAccountService;

    //검증을 위한 매서드
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String id = (String) authentication.getPrincipal();
        AccountContext accountContext = (AccountContext) jwtAccountService.loadUserByUsername(id);

        //디비에서 계정 조회 후, JwtAccountService 층에서 권한을 넣어주고 반환 받은 값을 토큰에 넣고 토큰 객체 생성.
        JwtUsernamePasswordAuthenticationToken authenticationToken = new JwtUsernamePasswordAuthenticationToken(accountContext.getAccount(), null, accountContext.getAuthorities());
        return authenticationToken;
    }

    //현재 authentication 인수와 토큰의 타입과 일치하면 JwtAuthenticationProvider가 인증을 완료하도록 설정.
    @Override
    public boolean supports(Class<?> authentication) {
        return JwtUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
