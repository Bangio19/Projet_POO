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
 * Modifier le cours (son nom ou son type) dans une séance de cours
 *
 * @author Bauti
 */
public class ModifNomCours extends JFrame {

    private DBConnect conn;
    Connection connect;
    private final JPanel p0, p1, nord;
    static JTextField nameInput, seanceIdInput;
    static JFrame f;
    private final JButton exec;
    // combobox 
    private JComboBox c1;
    private int id_Eleve;

    /**
     * Affecte/Ajoute un groupe spécifique à une séance spécifique
     */
    public ModifNomCours() {
        super();

        nord = new JPanel();

        f = new JFrame("Modifier un cours");

        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        p0 = new JPanel();
        p1 = new JPanel();
        p0.setLayout(new GridLayout(1, 2));
        p1.setLayout(new GridLayout(5, 1));
        nord.setLayout(new GridLayout(f.getHeight(), 1));

        seanceIdInput = new JTextField("Entrer l'ID de la séance");
        String infos = "*Pour changer le nom, veuillez entrer l'id du cours correspondant";
        String analyse = "1- Analyse";
        String tds = "2- Traitement du Signal";
        String engl = "3- English";
        String ital = "4- Italien";
        String thermo = "5- Thermodynamique";
        String robo = "6- Robotique";
        String ant = "7- Anthropologie";
        String edl = "8- Ethique de l'ingénieur";
        String pste = "9- PSTE";
        String poo = "10- POO Java";
        // array of string contating cities 
        String s1[] = {analyse, tds, engl, ital, thermo, robo, ant, edl, pste, poo};

        // create checkbox 
        c1 = new JComboBox(s1);

        p1.add(c1);

        exec = new JButton("Executer");

        p0.add(seanceIdInput);
        p0.add(exec);
        nord.add("North", p0);
        nord.add("North", p1);

        exec.addActionListener(new ModifNomCours.searchListener());

        //Connexion à la BDD
        conn = new DBConnect();
        connect = conn.getCon();

        JLabel sep = new JLabel("*****************************");

        montrer();
        nord.add(sep);

        // disposition geographique des panneaux
        add("North", nord);

        setVisible(true);
    }

    private class searchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            conn = new DBConnect();
            connect = conn.getCon();
            Mise_a_jour maj = new Mise_a_jour();

            try {
                String id = (String) c1.getSelectedItem();

                String value = c1.getSelectedItem().toString();

                String seinput = seanceIdInput.getText();
                int id_s = Integer.parseInt(seinput);

                if ("1- Analyse".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(1);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                    
                } else if ("2- Traitement du Signal".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(2);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("3- English".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(3);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("4- Italien".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(4);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("5- Thermodynamique".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(5);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("6- Robotique".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(6);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("7- Anthropologie".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(7);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("8- Ethique de l'ingénieur".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(8);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("9- PSTE".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(9);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                } else if ("10- POO Java".equals(value)) {
                    SeanceDAO seanceDAO = new SeanceDAO(connect);
                    Seance seance = seanceDAO.trouver(id_s);

                    CoursDAO coursDAO = new CoursDAO(connect);
                    Cours cours = coursDAO.trouver(10);
                    maj.modif_nom_cours_dans_seance(cours, seance);
                    montrer();
                }

            } catch (NumberFormatException a) {
                System.out.println("c'est une lettre");
            }

        }

    }

    public void montrer() {
        //Recuperation de tous les groupes
        Recherche search = new Recherche();

        ArrayList<Seance> listSeances = search.getAllSeances();
        for (int i = 0; i < listSeances.size(); i++) {
            JLabel seances = new JLabel(listSeances.get(i).toString(search.getCoursName(listSeances.get(i).getIdCours())));
            nord.add(seances);
        }
    }
}
