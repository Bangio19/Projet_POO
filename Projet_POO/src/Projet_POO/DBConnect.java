/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_POO;

import java.sql.*;
/**
 *
 * @author Bauti
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/planning?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Paris", "root", "");
            st = con.createStatement();
            System.out.println("Connexion à la BDD réussie");
         
        } catch (Exception ex) {
            System.out.println("Error: " + ex);

        }
    }
    
    public Connection getCon(){return con;}
    
    public void getData() {
        try {
            String query = "select * from promotion";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while (rs.next()) {
                String ID = rs.getString("ID");
                String NOM = rs.getString("NOM");
                System.out.println("ID: " + ID + " NOM: " + NOM);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
