/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Connexion;
import DAO.*;
import Model.*;
import Controller.*;
import Projet_POO.DBConnect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Bauti
 */
public class AffectGroupe extends JFrame {
    private DBConnect conn;
    Connection connect;
    private final JPanel p0, nord;
    static JTextField ensIdInput, seanceIdInput;
    static JFrame f;
    private final JButton exec;

    private int id_Eleve;

    /**
     * Affecte/Ajoute un groupe spécifique à une séance spécifique 
     */
    public AffectGroupe() {
        super();

        nord = new JPanel();

        f = new JFrame("Affecter Enseignant");

        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p0.setLayout(new GridLayout(1, 2));
        nord.setLayout(new GridLayout(f.getHeight(), 1));

        ensIdInput = new JTextField("Entrer l'ID du groupe");
        seanceIdInput = new JTextField("Entrer l'ID de la séance");

        exec = new JButton("Executer");

        p0.add(ensIdInput);
        p0.add(seanceIdInput);
        p0.add(exec);
        nord.add("North", p0);

        exec.addActionListener(new AffectGroupe.searchListener());

        //Connexion à la BDD
        conn = new DBConnect();
        connect = conn.getCon();

        //Recuperation de tous les groupes
        Recherche search = new Recherche();
        ArrayList<Groupe> listGroupe = search.getAllGroups();
        ArrayList<Seance> listSeances = search.getAllSeances();
        for (int i = 0; i < listGroupe.size(); i++) {
            JLabel ens = new JLabel(listGroupe.get(i).toString(search.getPromoName(listGroupe.get(i).getIdPromotion())));
            nord.add(ens);
        }
        JLabel sep = new JLabel("*****************************");
        //Recuperation de toutes les séances existantes
        nord.add(sep);
        for (int i = 0; i < listSeances.size(); i++) {
            JLabel seances = new JLabel(listSeances.get(i).toString(search.getCoursName(listSeances.get(i).getIdCours())));
            nord.add(seances);
        }

        
        // disposition geographique des panneaux
        add("North", nord);

        setVisible(true);
    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            conn = new DBConnect();
            connect = conn.getCon();

            try {
                String grpinput = ensIdInput.getText();
                int id_e = Integer.parseInt(grpinput);
                
                String seinput = seanceIdInput.getText();
                int id_s = Integer.parseInt(seinput);

                GroupeDAO grpDAO = new GroupeDAO(connect);
                Groupe groupe = grpDAO.trouver(id_e);

                SeanceDAO seanceDAO = new SeanceDAO(connect);
                Seance seance = seanceDAO.trouver(id_s);

                Mise_a_jour maj = new Mise_a_jour();

                maj.ajouter_groupe_a_seance(groupe, seance);
            } catch (NumberFormatException a) {
                System.out.println("c'est une lettre");
            }

        }
    }
}
