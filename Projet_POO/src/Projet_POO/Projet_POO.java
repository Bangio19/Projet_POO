/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_POO;
import Controller.Recherche;
import DAO.*;
import Model.*;
import java.util.*;
import java.sql.*;
import Projet_POO.DBConnect;
import java.text.*;

/*
 *
=======

 /*
>>>>>>> 7e5c9b9b1d9702ce06a7fb7a700892db0b540ffa
 * @author Bauti
 */
public class Projet_POO {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnect conn = new DBConnect();
        //connect.getData();
       
        Connection connect=conn.getCon();
        
        int id=16;
        //SalleDAO salleDao=new SalleDAO(connect);
        DAO<Enseignant> enseignantDao= new EnseignantDAO(connect);

        Enseignant prof= enseignantDao.trouver(id);
       /* DAO<Groupe> groupeDao= new GroupeDAO(connect);
        
        //int id = 3;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("le nom du groupe : ");
        String nom = sc.next();
        System.out.println("la promo du groupe : ");
        int id_promo = sc.nextInt();
        
        Groupe grp = new Groupe(1,nom, id_promo);
        groupeDao.creer(grp);*/
        
        //DAO<Seance> SeanceDao= new SeanceDAO(connect);
        //DAO<Promotion> PromotionDao= new PromotionDAO(connect);
        //int id = 3;

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("la semaine : ");
        int id = sc.nextInt();
        System.out.println("la date : ");
        

        String dateee = sc.next();
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        try {
            java.util.Date date = format.parse(dateee);
            java.sql.Date dateDB = new java.sql.Date(date.getTime());
        
            System.out.println("la heure debut : ");
            String heureD = sc.next();
            Time heure_d =  Time.valueOf(heureD);
        
        System.out.println("la heure fin : ");
        String heureF = sc.next();
            Time heure_f =  Time.valueOf(heureF);
        System.out.println("la etat : ");
        int etat = sc.nextInt();
        System.out.println("la id_cours : ");
        int id_cours = sc.nextInt();
        System.out.println("la id_type : ");
        int id_type = sc.nextInt();
        Seance nouveau = new Seance(1,id,dateDB, heure_d, heure_f, etat, id_cours, id_type);
        SeanceDao.creer(nouveau);
        } 
        catch (ParseException ex) {
            Logger.getLogger(SeanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
*/

        
        System.out.println("ENseignant Id: "+prof.getId());
        System.out.println("enseignnant cours: "+prof.getCours());

        

    }
    
}
