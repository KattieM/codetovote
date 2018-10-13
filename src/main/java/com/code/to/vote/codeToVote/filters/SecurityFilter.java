package com.code.to.vote.codeToVote.filters;

import com.code.to.vote.codeToVote.domain.UserEntity;
import com.code.to.vote.codeToVote.service.impl.SecurityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SecurityFilter implements Filter{

    private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    @Autowired
    SecurityServiceImpl securityService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
        logger.info("HTTP REQUEST");

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,PUT,PATCH,DELETE,POST,OPTIONS");
        httpResponse.addHeader("Access-Control-Max-Age", "3600");
        httpResponse.addHeader("Access-Control-Allow-Headers",
                "Origin, x-requested-with, X-AUTH-TOKEN, Content-Type, Accept");


        String uri = httpRequest.getRequestURI();

        if(httpRequest.getMethod().equalsIgnoreCase("options")) {
            filter.doFilter(request, response);
        } else {
            if(httpRequest.getRequestURI().contains("login")
                    || httpRequest.getRequestURI().contains("returnAll")
                    || httpRequest.getRequestURI().contains("returnById")
                    || httpRequest.getRequestURI().contains("register")
                    || httpRequest.getRequestURI().contains("delete")
                    || httpRequest.getRequestURI().contains("save")
                    || httpRequest.getRequestURI().contains("createPresentation")
                    || httpRequest.getRequestURI().contains("mail") || httpRequest.getRequestURI().contains("vote")){
                logger.info("URL: {}", httpRequest.getRequestURL());
                logger.info("METHOD TYPE: {}", httpRequest.getMethod());
                logger.info("NO SECURE NEEDED FOR THIS API REQUEST : {} ", httpRequest.getRequestURI().toString());
                filter.doFilter(request, response);
            } else {
                UserEntity credentials;
                logger.info("SUPER USER TOKEN NEEDED FOR THIS API CALL");
                try {
                    credentials = securityService.authenticateHttpRequest(httpRequest);
                } catch(Exception e) {
                    credentials = null;
                    httpResponse.setStatus(401);
                    logger.error("SecurityService exception: {} " + e.getMessage());
                }

                if(credentials == null) {
                    httpResponse.setStatus(401);
                } else {
                    filter.doFilter(request, response);
                }

            }
        }


    }

    @Override
    public void destroy() {

    }
}
