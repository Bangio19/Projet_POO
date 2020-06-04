/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bauti
 */
public class SeanceGroupe {
     int id_seance;
    int id_groupe;
    
    public SeanceGroupe(int id_s, int id_g){
        id_seance=id_s;
       id_groupe=id_g;
    }
    
    public int getIdSeance(){return id_seance;} 
    public int getIdGroupe(){return id_groupe;}
    
    public void setIdEnseignant(int id_g){id_groupe=id_g;}
}
