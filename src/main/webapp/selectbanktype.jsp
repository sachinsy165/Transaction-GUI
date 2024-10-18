 <%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_Account_creation_page</h1>
<!-- <h1>Hello kedar jadav</h1>-->
<%  Customer customer     =(Customer) request.getSession().getAttribute("customer");   %>
<h1>Hello:<%=customer.getName() %></h1>
<h1>Select_bank_type</h1>
<form action="createbankaccount" method="post">
<input type="radio" name="banktype" value="savings" required="required">Savings
<input type="radio" name="banktype" value="current">Current<br><br>
<button>Submit</button> <button type="reset">Cancel</button>
</form>


</body>
</html>