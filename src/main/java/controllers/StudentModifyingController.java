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

@WebServlet (name = "StudentModifyingController",urlPatterns = "/student-modifying")
public class StudentModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("modifyStudentHidden");
        Student modifStudent=DBManager.getStudentById(id);
        req.setAttribute("modifStudent",modifStudent);

        req.getRequestDispatcher("WEB-INF/jsp/student-creating.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modifId=req.getParameter("modifStudId");
        String modifSername=req.getParameter("newSername");
        String modifName=req.getParameter("newName");
        String modifGroup=req.getParameter("newGroup");
        Date modifDate= Date.valueOf(req.getParameter("newDate"));
        DBManager.modifyStudent(modifId,modifSername,modifName,modifGroup,modifDate);
        resp.sendRedirect("/students");
    }
}
