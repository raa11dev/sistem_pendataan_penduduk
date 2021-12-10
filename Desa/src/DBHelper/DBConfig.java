/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Senoramadhani
 */
public class DBConfig {
    private static Connection connection;
    public static Connection getDatabase() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/desasindangpakuon";
            String username = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        return connection;
    }
    
}
