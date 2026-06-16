/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.SessionDAO;
import com.Model.SessionBean;
import com.mysql.cj.Session;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author MP2-4
 */
public class BookSessionServlet extends HttpServlet {

    private SessionDAO SessionDAO;

    public void init() {
        SessionDAO = new SessionDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    insertRecord(request, response);
                    break;
                case "/insert":
                    insertRecord(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    private void insertRecord(HttpServletRequest request,
            HttpServletResponse response)
            throws SQLException, IOException {
        String student_name = request.getParameter("student_name");
        String branch_location = request.getParameter("branch_location");
        String lesson_type = request.getParameter("lesson_type");
        String status = request.getParameter("status");
        Schedule newSchedule = new schedule(student_name, branch_location, lesson_type, status);
        SessionDAO.insertRecord(newSchedule);
        response.sendRedirect("list");
    }
}
