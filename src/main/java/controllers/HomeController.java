package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "HomeController",urlPatterns = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req,resp);
        //req.setAttribute("currentPage","home.jsp");
        //req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req,resp);
    }

}
