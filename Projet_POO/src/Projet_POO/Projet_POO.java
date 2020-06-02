/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_POO;
import DAO.*;
import Model.*;
import java.sql.Connection;
/**
 *
 * @author Bauti
 */
public class Projet_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnect conn = new DBConnect();
        //connect.getData();
       
        Connection connect=conn.getCon();
         DAO<Salle> salleDao= new SalleDAO(connect);
        int id=2;
        //SalleDAO salleDao=new SalleDAO(connect);
        Salle salle=salleDao.trouver(id);
        
        System.out.println("Salle Id: "+salle.getId());
        System.out.println("Salle Nom: "+salle.getNom());
        System.out.println("Salle Capacite: "+salle.getCapacite());
        System.out.println("Salle Id_site: "+salle.getIdSite());
    }
    
}
