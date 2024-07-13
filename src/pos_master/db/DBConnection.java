/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos_master.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DBConnection {

    String url = "jdbc:mysql://localhost:3306/posmasterdb";
    String username = "root";
    String password = "root";
    public Connection con = null;
    public Statement st = null;
    public ResultSet rs = null;
    public PreparedStatement ps = null;

    public void connectDb() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed..!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeDb() {
        try {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot close database connection..!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

