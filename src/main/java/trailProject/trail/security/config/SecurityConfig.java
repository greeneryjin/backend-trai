package trailProject.trail.security.config;

//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.filter.CorsFilter;
//import trailProject.trail.security.filter.JwtAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final CorsFilter corsFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        //서버에 인증 정보를 저장하지 않기 때문에 csrf를 비활성화 함.
//        //현 서버는 jwt 방식을 사용안함, rest api는 csrf 보안 필요없음.
//        http.csrf().disable();
//        //세션 사용 안함.
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(corsFilter)
//                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                //폼 로그인 안함
//                .formLogin().disable()
//                .httpBasic().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll();
//    }
//}
