/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.Connexion;
/**
 *
 * @author antoi
 */
public class EnseignantMenu  extends JFrame implements ActionListener{
    
      private final JPanel container ,nord;
   private final JLabel lundi, mardi, mercredi, jeudi, vendredi,h1,h2,h3,h4,h5,h6,h7;
   
    private final JButton btn_emploi_du_temps, btn_recap_cours;
    
    public EnseignantMenu (int id){
        super();
      setTitle("Admin");
      setSize(1600,800);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      btn_emploi_du_temps = new JButton("Voir emploi du temps");
        btn_recap_cours = new JButton("Voir le recapitulatif des cours");
        
        btn_emploi_du_temps.addActionListener(this);
        btn_recap_cours.addActionListener(this);
      
       container = new JPanel();
       nord = new JPanel();
       
       lundi = new JLabel("Lundi");
       mardi= new JLabel("Mardi");
       mercredi = new JLabel("Mercredi");
       jeudi = new JLabel("Jeudi");
       vendredi = new JLabel("Vendredi");
       h1= new JLabel("8h / 10h");
       h2= new JLabel("10h15 / 11H45");
       h3= new JLabel("12h / 13h30");
       h4= new JLabel("13h45 / 15h15");
       h5= new JLabel("15h30 / 17h");
       h6= new JLabel("17h15 / 18h45");
       h7= new JLabel("19h / 20h30");
       
       nord.add("North", btn_emploi_du_temps);
	nord.add("North", btn_recap_cours);
       container.setLayout(new GridLayout(8,6));
       // On cherche une séance
       
       
         for(int i=0; i<48 ; i++){
          
            JPanel nouveau = new JPanel();
          
          // Jour de la semaine affichage
          if(i == 1){
              nouveau.add(lundi);
          }
          if(i == 2){
              nouveau.add(mardi);
          }
          if(i == 3){
              nouveau.add(mercredi);
          }
          if(i == 4){
              nouveau.add(jeudi);
          }
          if(i == 5){
              nouveau.add(vendredi);
          }
          
          // Horaire affichage 
          
           if(i == 6){
              nouveau.add(h1);
          }
          if(i == 12){
              nouveau.add(h2);
          }
          if(i == 18){
              nouveau.add(h3);
          }
          if(i == 24){
              nouveau.add(h4);
          }
          if(i == 30){
              nouveau.add(h5);
          }
           if(i == 36){
              nouveau.add(h6);
          }
          if(i == 42){
              nouveau.add(h7);
          }

          
          nouveau.setBorder(BorderFactory.createLineBorder(Color.black,1));
          container.add(nouveau);
            
        }
        
     add("North",nord);
     add("Center",container);
            
     
      
      setVisible(true);
      
        
        
    }
    
     public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btn_emploi_du_temps)
        {
            System.out.println("Voici votre emploi du temps de la semaine 1.");
            
        }
        else if(source == btn_recap_cours)
        {
            System.out.println("Voici votre récapitulatif de cours");
        }
    }
     
     
}
