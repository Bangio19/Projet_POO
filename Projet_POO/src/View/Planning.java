/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author antoi
 */
public class Planning extends JFrame {
  public Planning(){
      
      this.setTitle("Mon planning");
      this.setSize(1600,800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     this.setContentPane(Grille());
      
      this.setVisible(true);
     
  }
  private JPanel Grille(){
      JPanel container = new JPanel(new GridLayout(9,6));
      JLabel lundi = new JLabel("Lundi");
      JLabel mardi = new JLabel("Mardi");
      JLabel mercredi = new JLabel("Mercredi");
      JLabel jeudi = new JLabel("Jeudi");
      JLabel vendredi = new JLabel("Vendredi");
      
      for(int i=0; i<54 ; i++){
          JPanel nouveau = new JPanel();
          
          // Jour de la semaine 
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
          
          // Horaire 
          
           if(i == 6){
              nouveau.add(new JLabel("8h / 10h"));
          }
          if(i == 12){
              nouveau.add(new JLabel("10h15 / 11H45"));
          }
          if(i == 18){
              nouveau.add(new JLabel("12h / 13h30"));
          }
          if(i == 24){
              nouveau.add(new JLabel("13h45 / 15h15"));
          }
          if(i == 30){
              nouveau.add(new JLabel("15h30 / 17h"));
          }
           if(i == 36){
              nouveau.add(new JLabel("17h15 / 18h45"));
          }
          if(i == 42){
              nouveau.add(new JLabel("19h / 20h30"));
          }
          if(i == 48){
              nouveau.add(new JLabel("la faut rentrer maison"));
          }
          nouveau.setBorder(BorderFactory.createLineBorder(Color.black,1));
          container.add(nouveau);
      }
      
      
      return container;
}
