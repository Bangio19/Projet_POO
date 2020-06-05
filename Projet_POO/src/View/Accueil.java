/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Utilisateur;
import DAO.UtilisateurDAO;
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
    private final JLabel password, login , msgAccueil;
    private final JTextField pwd, log;
    
    
    
   
    public Accueil (){
         
        super();
        setTitle("Accueil");
    
      setSize(700,300);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      menu = new JPanel(new FlowLayout());
      
      msgAccueil = new JLabel("Rentrez votre mot de passe et email : /n"); 
      connexion = new JButton( "Connexion ");
      // Label
      password = new JLabel("Mot de passe :");
      login = new JLabel("Email : ");
      
      // Espaces de saisies
      pwd = new JTextField( 20 );
      log = new JTextField( 20);
      
      // Notre Bouton enclanche une action
      connexion.addActionListener(this);
      
      //afficahage dans notre JPanel menu
      menu.add(login);
      menu.add(log);
      menu.add(password);
      menu.add(pwd);
      
      menu. add(connexion); 
      
     
      
      setContentPane(menu);
      
      setVisible(true);
      
      
         
      }
      @Override
      public void actionPerformed(ActionEvent e){
       Object capture = e.getSource();
       if (capture == connexion){
           //connection à la bDD
           DBConnect conn = new DBConnect();
            Connection connect=conn.getCon();
            // Constructeur DAO
           UtilisateurDAO u = new UtilisateurDAO(connect);
           
           // On saisi ce que l'utilisateur a rentrer
           String utilLog = log.getText();
           String utilPwd = pwd.getText();
          
           //Récupération de l'utilisateur 
           
           Utilisateur NotreUtil = u.trouver(utilLog);
          
          if (utilLog.equals(NotreUtil.getEmail()) && utilPwd.equals(NotreUtil.getMdp()) ){
              
              int droit = NotreUtil.getDroit();
             // sélection du menu en fonction du droit de l'utilisateur 
              if (droit == 1){
                setVisible(false);
                AdminMenu nouveau = new AdminMenu();
              }
              if (droit == 2){
                  
                  setVisible(false );
                  ResponsableMenu nouveau = new ResponsableMenu();
              }
              if (droit == 3){
                  
                  setVisible(false);
                  EnseignantMenu nouveau = new EnseignantMenu();
              }
              if (droit == 4){
                  
                  setVisible(false);
                  EleveMenu nouveau = new EleveMenu();
              }
              
              
          }
          else{
              JOptionPane.showMessageDialog(null,"Mot de passe incorect");
          }
           
           
       }       
       
      
    }
    
    
   
   
    
    
}
