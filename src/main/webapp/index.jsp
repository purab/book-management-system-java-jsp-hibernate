 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
 <style type="text/css">
<%@include file="../css/style.css" %>

</style>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
</head>
<body>
<div class="container">
<h2 style="text-align: center;" >Book Management</h2>


<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="container">
<h2 style="text-align: center;" >School Book management</h2>
 <form action="login.jsp" method="post">
<div class="row" >
<div class="col">
<!-- left part -->
</div>
<div class="col" >
<table style="margin: 10px; ">
<tr><td>Username:</td><td><input type="text" name="username" > </td></tr>
<tr><td>Password: </td><td> <input type="password" name="password"> </td></tr>
<tr><td> </td><td><input type="submit" class="button" value="Login" >  Not registered <a href="register.jsp">click</a>  </td></tr>
</table>
</div>
</div>
</form>
</div>
</body>
</html>