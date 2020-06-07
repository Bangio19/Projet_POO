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
public class AnnValSeance extends JFrame {

    private DBConnect conn;
    Connection connect;
    private final JPanel p0, p1, nord;
    static JTextField nameInput, seanceIdInput;
    static JFrame f;
    private final JButton exec;
    // combobox 
    private JComboBox c1;
    private int id_Eleve;
    private LayoutManager mgr;

    public AnnValSeance() {
        super();

        nord = new JPanel();

        f = new JFrame("Modifier un cours");

        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p1 = new JPanel();

        p0.setLayout(new GridLayout(1, 1));
        p1.setLayout(new GridLayout(1, 2));

        nord.setLayout(new GridLayout(f.getHeight(), 1));

        seanceIdInput = new JTextField("Entrer l'ID de la séance");
        JLabel infos = new JLabel("Selectionnez votre choix et l'ID de la séance concernée");
        String an = "Annuler";
        String val = "Valider";

        // array of string contating cities 
        String s1[] = {an, val};

        // create checkbox 
        c1 = new JComboBox(s1);

        

        exec = new JButton("Executer");

        exec.addActionListener(new AnnValSeance.searchListener());

        p0.add(infos);
        p1.add(seanceIdInput);
        p1.add(c1);

        nord.add("North", p0);
        nord.add("North", p1);
        nord.add("North", exec);
        //Recuperation de toutes les séances
        Recherche search = new Recherche();
        ArrayList<Seance> listSeances = search.getAllSeances();
        for (int i = 0; i < listSeances.size(); i++) {
            JLabel seances = new JLabel(listSeances.get(i).toString(search.getCoursName(listSeances.get(i).getIdCours())));
            nord.add(seances);
        }
        add("North", nord);
        setVisible(true);
    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            conn = new DBConnect();
            connect = conn.getCon();
            Mise_a_jour maj = new Mise_a_jour();

            String id = (String) c1.getSelectedItem();

            String value = c1.getSelectedItem().toString();

            String seinput = seanceIdInput.getText();
            int id_s = Integer.parseInt(seinput);
            try {
                if ("Annuler".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    maj.annuler_seance(seance);

                } else if ("Valider".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    maj.valider_seance(seance);

                }
            } catch (NumberFormatException a) {
                System.out.println("c'est une lettre");
            }
        }
    }
}
