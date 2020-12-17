package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "StudentsController",urlPatterns = "/students")
public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> gettingStudents= DBManager.getAllActiveStudents();
        req.setAttribute("gettingStudents",gettingStudents);
        req.getRequestDispatcher("WEB-INF/jsp/students.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids=req.getParameter("deleteStudentHidden");
        String[] studIdArr=ids.split(",");
        for (String id:studIdArr) {
            DBManager.deleteStudent(id);
        }
        resp.sendRedirect("/students");

    }

}
