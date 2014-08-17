package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.PizzaAPIs;

/**
 */
public class AuthenticationFilter implements Filter {

    private String[] restrictedPageUrls = new String[]{"/homePage", "/signOut"}; //"/signUp","/signIn",

    private final static String APP_SERVER_END_POINT = "http://localhost:8080/freepizzaapp";
    private final static String HOME_PAGE_URL =  APP_SERVER_END_POINT + "/homePage";
    private final static String SIGN_IN_PAGE_URL =  APP_SERVER_END_POINT + "/signIn";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println(">>>> Auth Filter");
        if(needAuthentication(request.getRequestURI())){
            System.out.println(">>>> Need Authentication");
            if(isAlreadyAuthenticated(request.getSession())){
                System.out.println(">>>> Already Authenticated. Allow access.");
                chain.doFilter(request, response);
            }
            else{
                System.out.println(">>>> Not already authenticated. Do not allow access. Redirect to sign in.");
                response.sendRedirect(SIGN_IN_PAGE_URL);
            }
        }
        else{
            System.out.println(">>>> Does not need authentication. Public resource.");
            if(isAuthenticationResource(request.getRequestURI()) && isAlreadyAuthenticated(request.getSession()) ){ // e.g. signUp, signIn
                System.out.println(">>>> Already Authenticated. trying to access signUp, signIn. Redirect to Home Page.");
                response.sendRedirect(HOME_PAGE_URL);
            }
            else{
                System.out.println(">>>> Not already authenticated. Allow access.");
                chain.doFilter(request, response);
            }
        }
    }

    private boolean needAuthentication(String requestUri) {
        if(null != restrictedPageUrls){
            for(String restrictedPageUrl : restrictedPageUrls){
                if(requestUri.contains(restrictedPageUrl)){
                    return true;
                }
            }
        }
     return false;
    }

    private boolean isAuthenticationResource(String requestUri){
        if(requestUri.contains("/signUp") || requestUri.contains("/signIn")){
            return true;
        }
        return false;
    }

    private boolean isAlreadyAuthenticated(HttpSession httpSession){
        return (null != httpSession.getAttribute(PizzaAPIs.EMAIL));
    }

    @Override
    public void destroy() {
        // Do nothing
    }
}
