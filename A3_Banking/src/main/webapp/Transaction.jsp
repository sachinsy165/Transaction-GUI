<%@page import="Dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome_to_transaction_page</h1>
<body>
<%    long acno    =(long)request.getSession().getAttribute("ac_number"); 


  BankDao bankDao  =new BankDao();
 Bank_account bank_account    = bankDao.find(acno);
 
  List<BankTransaction>  list   =bank_account.getList();


%>
<%=bank_account.getAcc_no() %>
<%=bank_account.getAccount_type() %>

<table border="1">
<tr>
<th>Tid</th>
<th>Deposit</th>
<th>Withdraw</th>
<th>Balance</th>
<th>Transaction_time</th>
</tr>

<% for ( BankTransaction bankTransaction:list) {%>
<tr>
<th><%=bankTransaction.getTid() %></th>
<th><%=bankTransaction.getDeposit() %></th>
<th><%=bankTransaction.getWithdraw() %></th>
<th><%=bankTransaction.getBalance()%></th>
<th><%=bankTransaction.getDate_time() %></th>
 </tr>

<%} %>
</table><br><br>

<a href="Accounthome.html"><button>Back</button></a>

</body>
</html>