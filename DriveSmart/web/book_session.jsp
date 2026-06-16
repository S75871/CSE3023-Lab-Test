<%-- 
    Document   : book_session
    Created on : 16 Jun 2026, 2:26:17 PM
    Author     : MP2-4
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DRIVESMART INTEGRATED ACADEMY</title>
        <link 
            rel="stylesheet" 
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
            crossorigin="anonymous"
            >
    </head>
    <body>


        <jsp:include page="header.html" />
        <div class="container mt-4 col-md-6">
            
            <c:if test="${employee != null}">
                <form action="insert" method="post">
                </c:if>

                <c:if test="${record != null}">
                    <input type="hidden" name="id" value="${record.id}">
                </c:if>

                <fieldset class="form-group">
                    <label>Student Name</label>
                    <input type="text" class="form-control" name="student_name" value="${record.student_name}" required>
                </fieldset>

                <fieldset class="form-group">
                    <label>Branch Location</label>
                    <input type="text" class="form-control" name="branch_location" value="${record.branch_location}" required>
                </fieldset>

                <fieldset class="form-group">
                    <label>Lesson Type</label>
                    <input type="text" class="form-control" name="lesson_type" value="${record.lesson_type}" required>
                </fieldset>


                <button type="submit" class="btn btn-success">Submit</button>
                <a href="list" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </body>
    <jsp:include page="footer.jsp" />

</html>