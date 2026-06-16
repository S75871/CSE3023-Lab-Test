/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Model;

public class SessionBean {

    private int session_id;
    private String student_name;
    private String branch_location;
    private String lesson_type;
    private String status;

    public SessionBean(int session_id, String student_name, String branch_location, String lesson_type, String status) {
        this.session_id = session_id;
        this.student_name = student_name;
        this.branch_location = branch_location;
        this.lesson_type = lesson_type;
        this.status = status;
    }


    // Klik kanan -> Insert Code -> Getters and Setters
    public int getSession_id() {
        return session_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public String getLesson_type() {
        return lesson_type;
    }

    // Tambah Getter & Setter (Guna Alt+Insert dalam NetBeans)
    public String getStatus() {
        return status;
    }

    public void setSession_id(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
