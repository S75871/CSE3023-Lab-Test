package com.DAO;

import com.Model.*;
import java.sql.*;
import java.util.*;

public class SessionDAO {

    // Connection Method
    private String jdbcURL = "jdbc:mysql://localhost:3306/drivesmart_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //public SessionBean validateLogin(String u, String p) throws SQLException {
        //try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {
            //ps.setString(1, u);
            //ps.setString(2, p);
            //ResultSet rs = ps.executeQuery();
            //if (rs.next()) {
                //SessionBean SessionBean = new SessionBean(u, p);
                //SessionBean.setSession_id(rs.getInt("session_id"));
                //return SessionBean;
            //}
       // }
        //return null;
   // }

    // Insert Method
    public void insertRecord(SessionBean r) throws SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("INSERT INTO Training_Sessions (student_name, branch_location, lesson_type, status) VALUES (?,?,?,?)")) {
            ps.setString(1, r.getStudent_name());
            ps.setString(2, r.getBranch_location());
            ps.setString(3, r.getLesson_type());
            ps.setString(4, r.getStatus());
            ps.executeUpdate();
        }
    }

    // Retrieve Method
    public List<SessionBean> getAllRecords() {
        List<SessionBean> list = new ArrayList<>();
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM Training_Sessions ORDER BY branch_location ASC")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SessionBean(rs.getInt("session_id"), rs.getString("student_name"), rs.getString("branch_location"), rs.getString("lesson_type"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //public SessionBean selectRecord(int id) {
      //  try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM Training_Sessions WHERE session_id=?")) {
       //     ps.setInt(1, id);
       //     ResultSet rs = ps.executeQuery();
       //     if (rs.next()) {
       //         return new SessionBean(rs.getInt("session_id"), rs.getString("student_name"), rs.getString("branch_location"), rs.getString("lesson_type"), rs.getString("status"));
      //      }
      //  } catch (SQLException e) {
           // e.printStackTrace();
      //  }
      // return null;
   // }

}
