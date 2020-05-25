/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Bauti
 */
public class SalleDAO extends DAO<Salle> {

    public SalleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean creer(Salle obj) {
        //Reste à modifier
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO SALLE ...");
            while (rs.next()) {
                String ID = rs.getString("ID");
                String NOM = rs.getString("NOM");
                System.out.println("ID: " + ID + " NOM: " + NOM);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
}
