package hyggy.backend.resume.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//SecurityConfig는 웹 애플리케이션의 보안 설정을 담당하는 클래스입니다.
//이 클래스는 Spring Security 프레임워크를 사용하여 웹 애플리케이션에 대한 인증 및 인가 설정을 관리합니다.
//후에 Spring Security와 JWT 관련 의존성을 추가하여 고쳐야된다.
//현재는 인증 문제로 인해 따로 처리하지않을시 오류가 발생한다.

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 이 경우 .antMatchers("/**").permitAll()을 사용하여 모든 URL 패턴에 대한 모든 요청을 허용하지만
    // .anyRequest().authenticated()를 사용하여 다른 모든 요청에 대한 인증이 필요합니다.
    // .and().csrf().disable()은 사용자를 대신하여 무단 작업을 방지하는 보안 기능인
    // CSRF(Cross-Site Request Forgery) 보호를 비활성화합니다.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}