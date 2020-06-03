/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_POO;
import DAO.*;
import Model.*;
import java.sql.Connection;
import java.util.*;
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
        
        /*DAO<Salle> salleDao= new SalleDAO(connect);
        int id=2;
        //SalleDAO salleDao=new SalleDAO(connect);
        Salle salle=salleDao.trouver(id);*/
       /* DAO<Groupe> groupeDao= new GroupeDAO(connect);
        
        //int id = 3;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("le nom du groupe : ");
        String nom = sc.next();
        System.out.println("la promo du groupe : ");
        int id_promo = sc.nextInt();
        
        Groupe grp = new Groupe(1,nom, id_promo);
        groupeDao.creer(grp);*/
        
        DAO<Enseignant> EnseignantDao= new EnseignantDAO(connect);
        
        //int id = 3;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("le id de l'enseignant : ");
        int id = sc.nextInt();

        System.out.println("la matiere de l'enseignant : ");
        int id_cours = sc.nextInt();
        Enseignant prof = new Enseignant(id, id_cours);
        EnseignantDao.creer(prof);        
        //System.out.println("Salle Id: "+promo.getId());
        //System.out.println("Salle Nom: "+promo.getNom());
        
    }
    
}
