<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.alfashop.model.Usuario" %>
<%
if(session.getAttribute("usu") == null){
    //response.sendRedirect("index.jsp");
    RequestDispatcher despachador = request.getRequestDispatcher("index.jsp");
    despachador.forward(request, response);
}
Usuario usu = (Usuario) session.getAttribute("usu");
%>