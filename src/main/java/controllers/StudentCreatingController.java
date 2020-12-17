package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet (name = "StudentCreatingController",urlPatterns = "/student-creating")
public class StudentCreatingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isCreated","1");
        req.getRequestDispatcher("WEB-INF/jsp/student-creating.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newSername=req.getParameter("newSername");
        String newName=req.getParameter("newName");
        String newGroup=req.getParameter("newGroup");
        Date newDate= Date.valueOf(req.getParameter("newDate"));
        DBManager.createNewStudent(newSername,newName,newGroup,newDate);
        resp.sendRedirect("/students");
    }
}
