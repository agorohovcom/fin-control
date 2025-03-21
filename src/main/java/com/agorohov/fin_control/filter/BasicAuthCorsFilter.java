package com.agorohov.fin_control.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class BasicAuthCorsFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Credentials", "true");

//        // Добавляем заголовок только для CORS-запросов (ещё так не пробовал)
//        String origin = request.getHeader("Origin");
//        if (origin != null && !origin.isEmpty()) {
//            response.addHeader("Access-Control-Allow-Credentials", "true");
//        }

        filterChain.doFilter(request, response);
    }
}
