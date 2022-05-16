package trailProject.trail.security.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.filter.CorsFilter;
import trailProject.trail.security.filter.JwtAuthenticationFilter;
import trailProject.trail.security.provider.JwtAuthenticationProvider;
import trailProject.trail.security.service.JwtAccountService;
import trailProject.trail.security.token.JwtProperties;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProperties jwtProperties;
    private final CorsFilter corsFilter;

    //filter 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider());
    }

    //로그인을 인증할 provider 등록.
    @Bean
    public JwtAuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider();
    }

    //로그인을 인증할 manager가 provider에게 위임
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtProperties);
        jwtAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return jwtAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //서버에 인증 정보를 저장하지 않기 때문에 csrf를 비활성화 함.
        //현 서버는 jwt 방식을 사용안함, rest api는 csrf 보안 필요없음.
        http.csrf().disable();
        //세션 사용 안함.
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter)
                //jwt 인증
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                //폼 로그인 안함
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/trail/users/*").hasRole("USER")
                .anyRequest()
                .permitAll();
    }
}
