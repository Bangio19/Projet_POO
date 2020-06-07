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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bauti
 */
public class SupprGroupe extends JFrame {

    private DBConnect conn;
    Connection connect;
    private final JPanel p1, nord;
    static JTextField grpIdInput, seanceIdInput;
    static JFrame f;
    private final JButton exec;
    // combobox 
    private JComboBox c1;
    private int id_Eleve;
    private LayoutManager mgr;

    public SupprGroupe() {
        super();

        nord = new JPanel();

        f = new JFrame("Modifier un cours");

        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p1 = new JPanel();

        p1.setLayout(new GridLayout(1, 2));

        nord.setLayout(new GridLayout(f.getHeight(), 1));

        grpIdInput = new JTextField("Entrer l'ID du groupe concerné");
        seanceIdInput = new JTextField("Entrer l'ID de la séance concernée");

        exec = new JButton("Executer");

        exec.addActionListener(new SupprGroupe.searchListener());

        p1.add(seanceIdInput);
        p1.add(exec);

        nord.add("North", p1);
        nord.add("North", exec);

        //Recuperation de tous les groupes
        Recherche search = new Recherche();
        ArrayList<Groupe> listGroupe = search.getAllGroups();
        for (int i = 0; i < listGroupe.size(); i++) {
            JLabel ens = new JLabel(listGroupe.get(i).toString(search.getPromoName(listGroupe.get(i).getIdPromotion())));
            nord.add(ens);
        }
         ArrayList<SeanceGroupe> seancesgrp = search.getAllSeanceGroups();
            for (int i = 0; i < seancesgrp.size(); i++) {
                JLabel seances = new JLabel(seancesgrp.get(i).toString());
                nord.add(seances);
            }

        add("North", nord);
        setVisible(true);
    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            removeAll();//or remove(JComponent)

            Recherche search = new Recherche();

            String grpinput = seanceIdInput.getText();
            int id_s = Integer.parseInt(grpinput);
            f = new JFrame("Supprimer un groupe");

            setLayout(new BorderLayout());
            setSize(1000, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            p1.setLayout(new GridLayout(1, 2));

            nord.setLayout(new GridLayout(f.getHeight(), 1));

            seanceIdInput = new JTextField("Entrer l'ID de la séance concernée");

            exec.addActionListener(new SupprGroupe.supprListener());

            

            p1.add(seanceIdInput);
            p1.add(exec);

            nord.add("North", p1);
            nord.add("North", exec);

            ArrayList<SeanceGroupe> seancesgrp = search.getAllSeanceGroups();
            for (int i = 0; i < seancesgrp.size(); i++) {
                JLabel seances = new JLabel(seancesgrp.get(i).toString());
                nord.add(seances);
            }
            
            add("North", nord);
            setVisible(true);
        }
    }

    
}
