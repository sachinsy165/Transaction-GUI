<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome_to_account_creation_page</h1>
 
<%Customer customer= (Customer) request.getSession().getAttribute("customer");%>
<h1>Hello:Dear  <%=customer.getCname() %></h1>
<body>
<form action="createbankaccount">
<input type="radio" name="accounttype" value="savings" required="required">Savings
<input type="radio" name="accounttype" value="current">Current<br><br>
<button>Submit</button><button type="reset">Cancel</button>
</form>
</body>
</html>