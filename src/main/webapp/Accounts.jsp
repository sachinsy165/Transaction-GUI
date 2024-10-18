 <%@page import="Dto.Bankaccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_Accounts_page</h1>
<%   List<Bankaccount> list    =( List<Bankaccount>) request.getSession().getAttribute("list");

if(list.isEmpty())
{%>

<h1>No_active_accounts_found</h1>

	
<%}else{ %>

<%for(Bankaccount bankaccount:list) {%>

<a href="setactiveaccount?acno=<%=bankaccount.getAcc_no()%>"><button><%=bankaccount.getAcc_no() %></button></a>

<%}%>

<%}%>
 
</body>
</html>