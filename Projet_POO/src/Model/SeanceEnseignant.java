/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
/**
 *
 * @author Bauti
 */
public class SeanceEnseignant {
    int id_seance;
    int id_enseignant;
    
    public SeanceEnseignant(int id_s, int id_e){
        id_seance=id_s;
       id_enseignant=id_e;
    }
    
    public int getIdSeance(){return id_seance;} 
    public int getIdEnseignant(){return id_enseignant;}
    
    public void setIdEnseignant(int id_e){id_enseignant=id_e;}
}
