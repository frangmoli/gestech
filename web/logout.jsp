<%-- 
    Document   : logout
    Created on : 21-nov-2017, 20:51:41
    Author     : Fran y Angie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.invalidate();
response.sendRedirect("ingresar.jsp");
%>

