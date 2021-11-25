<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style type="text/css">
  <%@include file="../css/style.css" %>
 </style>
 <link rel="stylesheet" type="text/css" href="css/style.css" />
 <%@ include file="components/meta.jsp" %>
 <title>Home Page</title>
 <%@ include file="components/header.jsp" %>
</head>
<body>
<div class="view">
 <div class="pages">

  <div class="container">
   <h2 style="text-align: center;" >User Registeration</h2>
   <form action="registerAction.jsp" method="post">
    <div class="row" >
     <div class="col">
      <!-- left part -->
     </div>
     <div class="col" >
      <table>
       <tr><td>Full name</td><td><input type="text" name="fullName"> </td> </tr>
       <tr><td>Username :</td><td><input type="text" name="username"> </td> </tr>
       <tr><td>Password:</td><td><input type="password" name="password"> </td> </tr>
       <tr><td>Email :</td><td><input type="text" name="email" > </td> </tr>
       <tr><td>Phone: </td><td><input type="text" name="phone" > </td> </tr>
       <tr><td></td><td><input type="submit" value="Register"> </td> </tr>

      </table>
     </div>
    </div>
   </form>
  </div>




 </div>
</div>
<%@ include file="components/footer.jsp" %>
</body>
</html>