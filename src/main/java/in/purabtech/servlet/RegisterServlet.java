package in.purabtech.servlet;


import in.purabtech.config.DbConnection;
import in.purabtech.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operation = request.getParameter("option");
        User user=(User) request.getAttribute("userData");
        System.out.println(user.getFullName() +" user full name and email : "+user.getEmail());

        try {
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query="insert into users (user_name,user_pass,full_name,email, phone) "
                    + "values ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFullName()+"','"+user.getEmail()+"','"+user.getPhone()+"')";
            int i=st.executeUpdate(query);
            if(i>0) {
                response.getWriter().append("User added successfully...");
            }else {
                response.getWriter().append("Failed to add user...");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
