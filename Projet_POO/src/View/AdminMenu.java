/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author antoi
 */
public class AdminMenu extends JFrame {

    private final JPanel container, nord;

    private int idAdmin;

    private final JButton btnEmploiDuTemps, btnMajSeances;

    public AdminMenu(int id) {
        super();

        setVisible(true);
        idAdmin = id;
        nord = new JPanel();
        container = new JPanel();

        btnEmploiDuTemps = new JButton("Voir emploi du temps");
        btnMajSeances = new JButton("Mettre à jour des séances");

        btnEmploiDuTemps.addActionListener(new AdminMenu.edtListener());
        btnMajSeances.addActionListener(new AdminMenu.seancesListener());

        Connexion connexion = new Connexion();
        String nom_etudiant = connexion.get_nom(idAdmin);
        setTitle("Emploi du temps de " + nom_etudiant);
        setLayout(new BorderLayout());
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nord.setLayout(new GridLayout(1, 8));

        nord.add("North", btnEmploiDuTemps);
        nord.add("North", btnMajSeances);

        add("North", nord);
    }

    private class edtListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Planning planning = new Planning();
        }

    }
    
    private class seancesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SeancesMenu seances= new SeancesMenu();
        }

    }

}
