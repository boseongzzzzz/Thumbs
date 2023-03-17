package com.boram.life.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // spring security 보안 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                // ...antPatterns("웹페이지")에 대한 접근은 .hasRole("권한")이 있어야 가능, 혹은 .hasAnyRole("권한1", "권한2") 둘 중 하나의 권한이 있어야 가능.

                // 관리자 페이지(/manager)에 대한 권한 설정
                .antMatchers("/admin/**").hasRole("ADMIN")

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
    public WebSecurityCustomizer configure(){

        return (web) -> web.ignoring().antMatchers("/css/**, /image/**, /js/**, /video/** ");

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        /* 아래 내용은 (개발을 위한) '임시' 사용자 및 권한 설정 내용임 */
        auth.inMemoryAuthentication()

                // 사이트 관리자 계정 임시 설정
                .withUser("admin").password("{noop}admin").roles("ADMIN")

                // 인사부 계정 임시 설정
                .and()
                .withUser("insa1").password("{noop}insa1").roles("INSA")

                .and()
                .withUser("insa2").password("{noop}insa2").roles("INSA")

                .and()
                .withUser("insa3").password("{noop}insa3").roles("INSA")

                .and()
                .withUser("user").password("{noop}user").roles("EMPLOYEE");


    }



//    @Bean
//    public SecurityFilterChain loginFilter(HttpSecurity http) throws Exception{
//        return http.csrf().disable()
//                .authorizeRequests()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin().defaultSuccessUrl("/index")
//                    .and()
//                .logout()
//                .and()
//                .build();
//
//    }
}
