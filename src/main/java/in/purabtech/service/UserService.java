package in.purabtech.service;

import in.purabtech.config.DbConnection;
import in.purabtech.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getAllUsers(){
        Connection con = DbConnection.getConnection();
        Statement st;
        List<User> users= new ArrayList<User>();

        try {
            st = con.createStatement();
            ResultSet rs= st.executeQuery("select *from user_login");
            while (rs.next()) {
                User user= new User();
                user.setEmail(rs.getString("email"));
                user.setFullName(rs.getString("full_name"));
                user.setPhone(rs.getString("phone"));
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("user_pass"));
                user.setUsername(rs.getString("user_name"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
