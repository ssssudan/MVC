package org.example.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")   // 모든 경로에 대해서
public class CharacterEncodingFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_ENCODING);  // 요청 인코딩 UTF-8
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩 UTF-8

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
