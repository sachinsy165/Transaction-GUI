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

<h1>Welcome_to_account_home</h1>
<%  List<Bankaccount> list    =(List<Bankaccount>)request.getSession().getAttribute("list"); %>
<table border="1">
<tr>
<th>Account_number</th>
<th>Account_type</th>
<th>Balance</th>
<th>Account_limit</th>
<th>Account_status</th>
<th>Customer_name</th>
<th>Customer_id</th>
<th>Change_status</th>
</tr>

<% for(Bankaccount bankaccount:list) { %>
<tr>

<th><%=bankaccount.getAcc_no() %></th>
<th><%=bankaccount.getAccount_type() %></th>
<th><%=bankaccount.getAmount() %></th>
<th><%=bankaccount.getAcc_limit() %></th>
<th><%=bankaccount.isStatus() %></th>
<th><%=bankaccount.getCustomer().getName() %></th>
<th><%=bankaccount.getCustomer().getCustid() %></th>
<th><a href="changestatus?acno=<%=bankaccount.getAcc_no() %>"><button>Change_status</button></a></th>




</tr>






<%} %>
</table>
</body>
</html>