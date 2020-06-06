/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.*;
import java.sql.*;
import java.util.Scanner;
import Controller.*;
import java.util.*;
/**
 *
 * @author Bauti
 */ 
public class SeanceEnseignantDAO  {

    private Connection connect;

    public SeanceEnseignantDAO(Connection conn) {
        this.connect = conn;
    }

      
    public boolean creer(Enseignant Ens, Seance seance) {

        //Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();

            //System.out.println("Saisir Id Seance");
            int id_seance = seance.getId();

            //System.out.println("Saisir Id de l'Enseignatn");
            int id_enseignant = Ens.getId();

            int insertCount = statement.executeUpdate("INSERT INTO seance_enseignants VALUES('" + id_seance + "','" + id_enseignant + "')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean modifier(SeanceEnseignant obj) {
        try {
            Statement statement = this.connect.createStatement();
            int id_enseignant = obj.getIdEnseignant();
            System.out.println(id_enseignant);
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("UPDATE seance_enseignants SET ID_ENSEIGNANT='" + id_enseignant + "' WHERE ID_SEANCE='" + id_seance + "' ");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

      
    public boolean supprimer(SeanceEnseignant obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_enseignants WHERE ID_SEANCE=? AND ID_ENSEIGNANT=?");
            st.setInt(1, obj.getIdSeance());
            st.setInt(2, obj.getIdEnseignant());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    
    public boolean check_libre(Enseignant prof, Seance seance)
    {
        //SeanceEnseignant seanceEns = null;
        int id_prof= prof.getId();
        int id_seance = seance.getId();
        java.util.Date date_seance_a_verifier = seance.getDate();
        java.sql.Date dateDB = new java.sql.Date(date_seance_a_verifier.getTime());
        Time heure_debut= seance.getHeureDebut();
        
        try {
            
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst  = this.connect.prepareStatement("SELECT * FROM seance INNER JOIN seance_enseignants  ON  seance.ID = seance_enseignants.ID_SEANCE WHERE seance_enseignants.ID_ENSEIGNANT =? AND seance_enseignants.ID_SEANCE=? AND seance.DATE =? AND seance.HEURE_DEBUT=? ");
            pst.setInt(1, id_prof);
            pst.setInt(2, id_seance);
            pst.setDate(3, dateDB);
            pst.setTime(4, heure_debut);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.print("prof a deja un cours a ce jour la et a cette horaire la on ne change pas !");
                return false;

            }
            else
            {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    public SeanceEnseignant trouver(int id_s, int id_e) {
        SeanceEnseignant seanceEns = null;

        try {
            PreparedStatement pst = null;
            ResultSet rs = null;

            System.out.println("le int"+id_s);
            pst = this.connect.prepareStatement("SELECT * FROM seance_enseignants WHERE ID_SEANCE=? AND ID_ENSEIGNANT=? ");
            pst.setInt(1, id_s);
            pst.setInt(2, id_e);
            rs = pst.executeQuery();

            if (rs.next()) {
                seanceEns = new SeanceEnseignant( id_s, id_e);
                return seanceEns;
            }    
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceEns;
    }
    
    public ArrayList toutSelect(int id){
        
        ArrayList<SeanceEnseignant> se = new ArrayList<SeanceEnseignant>();
        try {
            PreparedStatement pst = null;
            ResultSet resultat = null;
            
              pst = this.connect.prepareStatement("SELECT * FROM seance_enseignant WHERE IDenseignant='"+id+"';");
              resultat= pst.executeQuery();
             ResultSetMetaData resultMeta = resultat.getMetaData();
             while(resultat.next()){
                 for (int i =1; i<resultMeta.getColumnCount(); i++){
                     SeanceEnseignant  seen = new SeanceEnseignant((int)resultat.getObject(i),id);
                     se.add(seen);
                 }
             }
        }catch(SQLException e){
            //Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
                      }
        return se;
        }
   
    }    
    
    


