package com.huangdekai.JavaWeb.SMBMS.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Autord: HuangDekai
 * @Date: 2020/5/7 22:58
 * @Version: 1.0
 * @since: jdk11
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
