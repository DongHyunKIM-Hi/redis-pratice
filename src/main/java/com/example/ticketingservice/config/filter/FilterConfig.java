package com.example.ticketingservice.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        log.info("안녕 안녕" );
        Long userId = 1L;
        request.setAttribute("userId", userId );
        filterChain.doFilter(request, response);
        log.info("잘가 잘가");


    }
}