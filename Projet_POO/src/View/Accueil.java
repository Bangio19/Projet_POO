
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;

import Model.*;
import DAO.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Projet_POO.DBConnect;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author antoi
 */
public class Accueil extends JFrame implements ActionListener {
    
    private final JPanel menu;
    private final JButton connexion;
    private final JLabel password, login ;
    private final JTextField pwd, log;
    
   public Accueil (){
         
        super();
        setTitle("Accueil");

        setSize(700,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu = new JPanel(new FlowLayout());
        
        //bouton
        connexion = new JButton( "Connexion ");
        
        // Label
        password = new JLabel("Mot de passe :");
        login = new JLabel("Email : ");

        // Espaces de saisies
        pwd = new JTextField(20);
        log = new JTextField(20);

        // Notre Bouton enclanche une action
        connexion.addActionListener(this);

        //afficahage dans notre JPanel menu
        menu.add(login);
        menu.add(log);
        menu.add(password);
        menu.add(pwd);
        menu.add(connexion); 

        setContentPane(menu);

       
    }
   
    @Override
    public void actionPerformed(ActionEvent e){
        Object capture = e.getSource();
        if (capture == connexion){
           //connection à la bDD
           
            String utilisateurLogin = log.getText();
            String utilisateurPwd = pwd.getText();
           
            Connexion connexion = new Connexion();
           
            connexion.verif_utilisateur_lancement_menu_correspondant(utilisateurLogin, utilisateurPwd);
            
            
        }
    }
}

