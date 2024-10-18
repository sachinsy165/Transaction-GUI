 <%@page import="Dto.Customer"%>
<%@page import="Dto.Bankaccount"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_check_balance_page</h1>

<%

   long acno  =(long)request.getSession().getAttribute("acno");

    BankDao bankDao=new BankDao();
    
  Bankaccount bankaccount     =  bankDao.fetch_by_accno(acno);
  
 Customer customer     = bankaccount.getCustomer();

%>
<h1>Hello <%=customer.getName() %> your  account balance is:<%=bankaccount.getAmount() %></h1>
</body>
</html>