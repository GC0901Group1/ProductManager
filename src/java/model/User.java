/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Phuc
 */
public class User {
    public boolean checkUser(String user, String pass){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://PHUC-PC:1433;databaseName=LoginMVC";
            String id = "sa";
            String password = "123456";
            Connection con = DriverManager.getConnection(url, id, password);
            PreparedStatement ps = con.prepareStatement("select * from [User] where Username = ? and Password = ?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
