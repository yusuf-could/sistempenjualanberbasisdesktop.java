/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author yusuf
 */
public class koneksi {
    public Connection bukakoneksi() throws SQLException{
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost/db_inventory";
        String user ="root";
        String pw ="";
        con = DriverManager.getConnection(url, user, pw);
    }catch(SQLException se){
        JOptionPane.showMessageDialog(null, "No Connection Open");
        System.out.println();
        return null;
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Couldn't Open Database");
        return null;
    }
    return con;
} 
}
