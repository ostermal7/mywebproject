package filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterPageFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        //отрабатывает в момент запуска томката единожды
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //работает на все контроллеры
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        Cookie[] cookies=request.getCookies();
        Cookie counter=getCookieByName(cookies,"counter");
        String value=counter.getValue();
        int count=Integer.parseInt(value);
        counter.setValue(count+1+"");
        response.addCookie(counter);

        filterChain.doFilter(request,response);
    }

    public void destroy() {
        //отрабатывает в момент запуска томката единожды

    }
    private Cookie getCookieByName(Cookie[] cookies,String name){
        if (cookies!=null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        Cookie cookie=new Cookie("counter","0");
        return cookie;
    }
}
