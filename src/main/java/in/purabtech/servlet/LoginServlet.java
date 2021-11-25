package in.purabtech.servlet;

import in.purabtech.config.DbConnection;
import in.purabtech.entity.User;
import in.purabtech.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@WebServlet("/loginss")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        User user= (User)request.getAttribute("loginUser");
        System.out.println("user name : "+user.getUsername() +"  and password : " +user.getPassword());
        try {

            Connection con = DbConnection.getConnection();
            HttpSession session = request.getSession();
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select *from users where user_name='"+user.getUsername()+"' and user_pass='"+user.getPassword()+"'");

            if(rs.next()) {
                UserService service = new UserService();
                List<User> list = service.getAllUsers();
                String uid= rs.getString("user_name");
                String pass=rs.getString("user_pass");
                session.setAttribute("userid", uid);
                System.out.println("DB username : "+uid +" and passsssss : "+pass) ;
                session.setAttribute("list", list);
                response.sendRedirect("home.jsp");
            }else {
                session.setAttribute("succMsg", "user credentials not correct...");
                System.out.println("#############################");
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
