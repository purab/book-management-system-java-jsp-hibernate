
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
  <%@ include file="components/meta.jsp" %>
  <title>Home Page</title>
  <%@ include file="components/header.jsp" %>
 </head>
 <body>
 <div class="view">
  <div class="pages">


   <div class="container">
    <% String e = (String) session.getAttribute("succMsg" );
     if(e != null)
     {
      out.print(e);
     }else{
      out.print("All Is Well");
     } %>
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





  </div>
 </div>
 <%@ include file="components/footer.jsp" %>
 </body>
 </html>