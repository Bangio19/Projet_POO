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
import java.util.ArrayList;

/**
 *
 * @author Bauti
 */
public class SeanceGroupeDAO {

    private Connection connect;

    public SeanceGroupeDAO(Connection conn) {
        this.connect = conn;
    }

    public boolean creer(Groupe grp, Seance seance) {

        //Scanner sc = new Scanner(System.in);
        try {
            Statement statement = this.connect.createStatement();

            //System.out.println("Saisir Id Seance");
            int id_seance = seance.getId();

            //System.out.println("Saisir Id de l'Enseignant");
            int id_groupe = grp.getId();

            int insertCount = statement.executeUpdate("INSERT INTO seance_groupes VALUES('" + id_seance + "','" + id_groupe + "')");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean modifier(SeanceGroupe obj) {
        try {
            Statement statement = this.connect.createStatement();
            int id_groupe = obj.getIdGroupe();
            int id_seance = obj.getIdSeance();

            int insertCount = statement.executeUpdate("UPDATE seance_groupes SET ID_GROUPE='" + id_groupe + "' WHERE ID_SEANCE='" + id_seance + "'");

            System.out.println("Inserted test_value successfully : " + insertCount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean supprimer(SeanceGroupe obj) {
        try {
            PreparedStatement st = this.connect.prepareStatement("DELETE FROM seance_groupes WHERE ID_SEANCE=? AND ID_GROUPE=?");
            st.setInt(1, obj.getIdSeance());
            st.setInt(2, obj.getIdGroupe());
            st.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean check_libre(Groupe grp, Seance seance) {
        //SeanceEnseignant seanceEns = null;
        int id_grp = grp.getId();
        int id_seance = seance.getId();
        java.util.Date date_seance_a_verifier = seance.getDate();
        java.sql.Date dateDB = new java.sql.Date(date_seance_a_verifier.getTime());
        Time heure_debut = seance.getHeureDebut();
        int capacite_mini = 0;

        try {

            PreparedStatement adr = null;
            ResultSet rz = null;
            adr  = this.connect.prepareStatement("SELECT COUNT(*) AS nbEtudiant FROM etudiant WHERE ID_GROUPE=?");
            adr.setInt(1, id_grp);
            rz = adr.executeQuery();
            rz.next();
            capacite_mini = rz.getInt("nbEtudiant");
            
            System.out.println("capacite mini : "+capacite_mini);
            
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst  = this.connect.prepareStatement("SELECT * FROM seance INNER JOIN seance_groupes  ON  seance.ID = seance_groupes.ID_SEANCE WHERE seance_groupes.ID_GROUPE =? AND seance_groupes.ID_SEANCE=? AND seance.DATE =? AND seance.HEURE_DEBUT=? ");
            pst.setInt(1, id_grp);
            pst.setInt(2, id_seance);
            pst.setDate(3, dateDB);
            pst.setTime(4, heure_debut);
            //System.out.println("YEssss");
            rs = pst.executeQuery();
            //System.out.println("YEs");
            
            /*ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance INNER JOIN seance_groupes  ON  seance.ID = seance_groupes.ID_SEANCE WHERE seance_groupes.ID_GROUPE = '"+id_grp+"' AND seance_groupes.ID_SEANCE= '"+id_seance+"' AND seance.DATE ='"+dateDB+"' AND seance.HEURE_DEBUT= '" + heure_debut);
            System.out.println("YEs");
            */

            if (rs.next()) {
                System.out.println(" Le groupe a deja un cours a ce jour la et a cette horaire la on ne change pas !");
                return false;

            } else {
                //IL ne reste plus qu'a verifier si la salle comporte assez de place pour le groupe !
                System.out.println("On est bon");

                PreparedStatement dbz = null;
                ResultSet db = null;
                dbz = this.connect.prepareStatement("SELECT * FROM seance_salles  WHERE ID_SEANCE =?");
                dbz.setInt(1, id_seance);
                db = dbz.executeQuery();
                
                if (db.next()) {
                    int a = db.getInt("ID_SALLE");
                    System.out.println("id_salle recupe : " + db.getInt("ID_SALLE"));

                    PreparedStatement one = null;
                    ResultSet yt = null;
                    one = this.connect.prepareStatement("SELECT * FROM salle  WHERE ID =?");
                    one.setInt(1, a);
                    yt = one.executeQuery();

                    if (yt.next()) {
                        System.out.println("Capacite de la salle : " + yt.getInt("CAPACITE"));
                        if (yt.getInt("CAPACITE") >= capacite_mini) {
                            return true;
                        }
                        System.out.print("Capacite inferieure de la salle!");
                    }
                    System.out.print("Pas trouve la capacite !");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }

    public ArrayList trouver_tous_les_groupes(int id) {
        ArrayList<SeanceGroupe> seances = new ArrayList<SeanceGroupe>();
        try {
            PreparedStatement adr = null;
            ResultSet rz = null;
            adr = this.connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_GROUPE=?");
            adr.setInt(1, id);
            rz = adr.executeQuery();
            ResultSetMetaData resultMeta = rz.getMetaData();

            while (rz.next()) {
                for (int i = 1; i < resultMeta.getColumnCount(); i++) {
                    SeanceGroupe seanGrp = new SeanceGroupe((int) rz.getObject(i), id);
                    seances.add(seanGrp);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seances;
    }

    public SeanceGroupe trouver(int id_s) {
        SeanceGroupe seanceGr = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_groupes WHERE ID_SEANCE = " + id_s);
            if (result.first()) {
                seanceGr = new SeanceGroupe(
                        id_s,
                        result.getInt("ID_GROUPE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceGr;
    }
}
