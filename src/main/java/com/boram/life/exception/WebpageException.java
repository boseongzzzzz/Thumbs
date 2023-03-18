package com.boram.life.exception;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// 웹 페이지 전역에서 일어나는 오류에 대해 동일한 뷰페이지를 반환하는 클래스
public class WebpageException implements HandlerInterceptor {

    // 처리할 내용
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 서버 오류
        if (response.getStatus() == HttpServletResponse.SC_INTERNAL_SERVER_ERROR) {
            response.sendRedirect(request.getContextPath() + "/error/500.html"); // 500 Forbidden 오류에 대한 페이지로 리다이렉트
            return false;
        }

        // 잘못된 요청
        if (response.getStatus() == HttpServletResponse.SC_BAD_REQUEST) {
            response.sendRedirect(request.getContextPath() + "/error/400.html"); // 400 Bad Request 오류에 대한 페이지로 리다이렉트
            return false;
        }

        // 권한이 없음
        if (response.getStatus() == HttpServletResponse.SC_FORBIDDEN) {
            response.sendRedirect(request.getContextPath() + "/error/403.html"); // 403 Forbidden 오류에 대한 페이지로 리다이렉트
            return false;
        }

        // 페이지가 없음
        if (response.getStatus() == HttpServletResponse.SC_NOT_FOUND) {
            response.sendRedirect(request.getContextPath() + "/error/404.html"); // 404 Not Found 오류에 대한 페이지로 리다이렉트
            return false;
        }

        return true;

    }

}