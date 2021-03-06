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
public class AffectEnseignants extends JFrame {

    private DBConnect conn;
    Connection connect;
    private final JPanel p0, nord;
    static JTextField ensIdInput, seanceIdInput;
    static JFrame f;
    private final JButton exec;

    private int id_Eleve;

    /**
     * Affecte/Ajoute un enseignant spécifique à une séance spécifique 
     */
    public AffectEnseignants() {
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

        ensIdInput = new JTextField("Entrer l'ID de l'enseignant");
        seanceIdInput = new JTextField("Entrer l'ID de la séance");

        exec = new JButton("Executer");

        p0.add(ensIdInput);
        p0.add(seanceIdInput);
        p0.add(exec);
        nord.add("North", p0);

        exec.addActionListener(new AffectEnseignants.searchListener());

        //Connexion à la BDD
        conn = new DBConnect();
        connect = conn.getCon();

        //Recuperation de tous les enseignants
        Recherche search = new Recherche();
        ArrayList<Utilisateur> listEnseignants = search.getAllUsers();
        ArrayList<Seance> listSeances = search.getAllSeances();
        for (int i = 0; i < listEnseignants.size(); i++) {
            JLabel ens = new JLabel(listEnseignants.get(i).getPrenom() + " " + listEnseignants.get(i).getNom() + ", ID: " + listEnseignants.get(i).getId());
            nord.add(ens);
        }
        JLabel sep = new JLabel("*****************************");
        nord.add(sep);
        for (int i = 0; i < listSeances.size(); i++) {
            JLabel seances = new JLabel(listSeances.get(i).toString(search.getCoursName(listSeances.get(i).getIdCours())));
            nord.add(seances);
        }

        //Recuperation de toutes les séances existantes
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
                String ensinput = ensIdInput.getText();
                int id_e = Integer.parseInt(ensinput);
                
                String seinput = seanceIdInput.getText();
                int id_s = Integer.parseInt(seinput);

                EnseignantDAO EnsDAO = new EnseignantDAO(connect);
                Enseignant prof = EnsDAO.trouver(id_e);

                SeanceDAO seanceDAO = new SeanceDAO(connect);
                Seance seance = seanceDAO.trouver(id_s);

                Mise_a_jour maj = new Mise_a_jour();

                maj.ajouter_enseignant_a_seance(prof, seance);
            } catch (NumberFormatException a) {
                System.out.println("c'est une lettre");
            }

        }
    }
}
