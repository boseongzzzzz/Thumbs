package com.boram.life.config;

import com.boram.life.login.LoginSuccessHandler;
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
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
// extends WebSecurityConfigurerAdapter

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private final LoginSuccessHandler authenticationSuccessHandler;

    @Autowired
    private final AuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. 기본 설정
        http.csrf().disable()
                .cors().disable()
                .formLogin().disable()
                .headers().frameOptions().disable();

        // 2. 권한 설정
        http.authorizeRequests()

                // 기본 접근 허용 경로
                .mvcMatchers("/login/**", "/css/**", "/image/**", "/js/**", "/error/**", "/pictures/**", "/attachments/**").permitAll()

                // 관리자 페이지(/manage)에 대한 권한 설정
                .antMatchers("/manage/**").hasRole("ADMIN")

                // 인사명령 결재문서(/gian/(인사명령)) 기안에 대한 권한 설정
                // 1:일반사원, 2:문서담당자, 3:인사담당자, 4:프로그램관리자
                .antMatchers("/gian/position-gian").hasAnyRole("ADMIN", "INSA")
                .antMatchers("/gian/promotion-gian").hasAnyRole("ADMIN", "INSA")
                .antMatchers("/gian/punishment-gian").hasAnyRole("ADMIN", "INSA")

                // 마이페이지(/myPage)에 대한 권한 설정
                .antMatchers("/myPage/**").hasAnyRole("EMPLOYEE", "DOCU", "INSA")

                // 이외에, 언급되지 않은 모든 페이지는 인증 요청됨
                .anyRequest().authenticated();


        http.formLogin()
                .loginPage("/login") // 로그인 페이지 경로
                .loginProcessingUrl("/login/do") // 로그인 처리 URL
                .successHandler(authenticationSuccessHandler)  // 로그인 성공 처리 핸들러
                .failureHandler(authenticationFailureHandler); // 로그인 실패 처리 핸들러

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃
                .logoutSuccessUrl("/login") // 성공 시 리턴할 경로
                .invalidateHttpSession(true); // (로그아웃 시) 인증정보 지움 여부
//                .deleteCookies("JSESSIONID", "remember-me"); // 세션 삭제 등 옵션

        http.sessionManagement()
                .maximumSessions(1) // 세션 최대 허용 수 1, -1인 경우 무제한 세션 허용
                .maxSessionsPreventsLogin(false) // true 면 중복 로그인을 막고, false면 이전 로그인의 세션을 해제
                .expiredUrl("/login"); // 세션 만료인 경우 이동할 URL

//        http.rememberMe() // 로그인 유지 옵션
//                .key("0467EC591838570F48CC386CEE6ED9FBA53B4593A283BAFD5A94347AD3428408") // 토큰 생성시 키값
//                .alwaysRemember(false) // 항상 기억할 것인지 여부
//                .tokenValiditySeconds(43200) // (단위:초), 해당 초만큼 유지
//                .rememberMeParameter("remember-me"); // 로그인 유지용 파라미터명

        return http.build();
    }
}


//}
//
//    // spring security 보안 설정
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//    }

//        http.authorizeRequests()
//
//                // ...antPatterns("웹페이지")에 대한 접근은 .hasRole("권한")이 있어야 가능, 혹은 .hasAnyRole("권한1", "권한2") 둘 중 하나의 권한이 있어야 가능.
//
//                // 관리자 페이지(/manage)에 대한 권한 설정
//                .antMatchers("/manage/**").hasRole("ADMIN")
//
//                // 인사명령 결재문서(/gian/(인사명령)) 기안에 대한 권한 설정
//                .antMatchers("/gian/position-gian").hasAnyRole("ADMIN", "INSA")
//                .antMatchers("/gian/promotion-gian").hasAnyRole("ADMIN", "INSA")
//                .antMatchers("/gian/punishment-gian").hasAnyRole("ADMIN", "INSA")
//
//                // 마이페이지(/myPage)에 대한 권한 설정
//                .antMatchers("/myPage/**").hasAnyRole("INSA", "EMPLOYEE")
//
//                .anyRequest().authenticated()
//                .and()
//
//                // 로그인 페이지(/login)에 대한 권한 설정
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .csrf().disable();
//
//    }
//
//
//    /* 시큐리티 설정을 무시할 정적 리소스를 등록 (resources 안의 static 폴더 내부의 정적리소스 유형 무시) */
//    @Bean
//    public static WebSecurityCustomizer webSecurityCustomizer(){
//
//        return (web) -> web.ignoring().antMatchers("/css/**", "/image/**", "/js/**", "/error/**", "/pictures/**", "/attachments/**");
//
//    }
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        /* 아래 내용은 (개발을 위한) '임시' 사용자 및 권한 설정 내용임 */
//        auth.inMemoryAuthentication()
//
//                // 사이트 관리자 계정 임시 설정
//                .withUser("admin").password("{noop}admin").roles("ADMIN")
//
//                // 인사부 계정 임시 설정
//                .and()
//                .withUser("1111").password("{noop}1111").roles("INSA")
//
//                .and()
//                .withUser("2222").password("{noop}2222").roles("INSA")
//
//                .and()
//                .withUser("3333").password("{noop}3333").roles("INSA")
//
//                .and()
//                .withUser("4444").password("{noop}4444").roles("EMPLOYEE");
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
