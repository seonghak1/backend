package hyggy.backend.search.config;

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

    //해당 코드에서는 모든 요청에 대해 접근 권한을 허용하도록 설정되어 있습니다.
    // authorizeRequests() 메서드로 권한 부여 설정을 하고,
    // antMatchers("/**").permitAll() 메서드로 모든 URL에 대해 접근 권한을 허용하도록 지정되어 있습니다.
    //그리고 csrf().disable() 메서드를 호출하여 CSRF(Cross-Site Request Forgery) 보호를 비활성화시켰습니다.


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and().csrf().disable();
    }
}