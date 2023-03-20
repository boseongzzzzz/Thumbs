package com.boram.life.config;

import com.boram.life.member.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;

    // spring security 보안 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                // ...antPatterns("웹페이지")에 대한 접근은 .hasRole("권한")이 있어야 가능, 혹은 .hasAnyRole("권한1", "권한2") 둘 중 하나의 권한이 있어야 가능.

                // 관리자 페이지(/manage)에 대한 권한 설정
                .antMatchers("/manage/**").hasRole("ADMIN")

                // 인사명령 결재문서(/gian/(인사명령)) 기안에 대한 권한 설정
                .antMatchers("/gian/position-gian").hasAnyRole("ADMIN", "INSA")
                .antMatchers("/gian/promotion-gian").hasAnyRole("ADMIN", "INSA")
                .antMatchers("/gian/punishment-gian").hasAnyRole("ADMIN", "INSA")

                // 마이페이지(/myPage)에 대한 권한 설정
                .antMatchers("/myPage/**").hasAnyRole("INSA", "EMPLOYEE")

                .anyRequest().authenticated()
                .and()

                // 로그인 페이지(/login)에 대한 권한 설정
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();

    }


    /* 시큐리티 설정을 무시할 정적 리소스를 등록 (resources 안의 static 폴더 내부의 정적리소스 유형 무시) */
    @Bean
    public static WebSecurityCustomizer webSecurityCustomizer(){

        return (web) -> web.ignoring().antMatchers("/css/**", "/image/**", "/js/**", "/error/**");

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        /* 아래 내용은 (개발을 위한) '임시' 사용자 및 권한 설정 내용임 */
        auth.inMemoryAuthentication()

                // 사이트 관리자 계정 임시 설정
                .withUser("admin").password("{noop}admin").roles("ADMIN")

                // 인사부 계정 임시 설정
                .and()
                .withUser("1111").password("{noop}1111").roles("INSA")

                .and()
                .withUser("2222").password("{noop}2222").roles("INSA")

                .and()
                .withUser("3333").password("{noop}3333").roles("INSA")

                .and()
                .withUser("4444").password("{noop}4444").roles("EMPLOYEE");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }
}
