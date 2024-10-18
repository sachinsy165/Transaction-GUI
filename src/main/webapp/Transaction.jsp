 <%@page import="Dto.BankTransaction"%>
<%@page import="java.util.List"%>
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
<h1>Welcome_to_transaction_page</h1>
<body>
<%    long acno    =(long)request.getSession().getAttribute("acno"); 


  BankDao bankDao  =new BankDao();
 Bankaccount bank_account    = bankDao.fetch_by_accno(acno);
 
  List<BankTransaction>  list   =bank_account.getBankTransactions();


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
<th><%=bankTransaction.getLocalDateTime() %></th>
 </tr>

<%} %>
</table><br><br>

<a href="Home.html"><button>Back</button></a>

</body>
</html>