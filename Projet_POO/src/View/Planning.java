/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import DAO.SeanceDAO;

/**
 *
 * @author antoi
 */
public class Planning extends JFrame {
    
    private final JPanel container;
    private final JLabel lundi, mardi, mercredi, jeudi, vendredi,h1,h2,h3,h4,h5,h6,h7; 
            
  public Planning(){
      super();
      setTitle("Mon planning");
      setSize(1600,800);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       container = new JPanel();
       
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
       
      container.setLayout(new GridLayout(8,6));
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
     
     setContentPane(container);
      
      setVisible(true);
      
     
  }
  
      
      

}
}
