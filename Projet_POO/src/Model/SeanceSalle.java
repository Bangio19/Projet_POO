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
public class SeanceSalle {
    int id_seance;
    int id_salle;
    
    public SeanceSalle(int id_s, int id_sal){
        id_seance=id_s;
       id_salle=id_sal;
    }
    
    public int getIdSeance(){return id_seance;} 
    public int getIdSalle(){return id_salle;}
    
    public void setIdEnseignant(int id_sal){id_salle=id_sal;}
}
