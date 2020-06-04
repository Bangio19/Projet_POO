/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import DAO.*;
import Projet_POO.DBConnect;
import java.util.*;
import java.sql.Connection;

/**
 *
 * @author adrie
 */
public class Recherche {
    
    ArrayList<Seance> listSeance= new ArrayList<Seance>();
    
    public void consulter_cours_enseignant(Enseignant prof,int semaine)
    {
        DBConnect conn = new DBConnect();
       
        Connection connect=conn.getCon(); 
        
        DAO<Seance> SeanceDao = new SeanceDAO(connect);
        
    }
}
