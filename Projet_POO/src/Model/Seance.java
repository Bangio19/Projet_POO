/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author adrie
 */
public class Seance {
    private int m_id;
    private int m_semaine;
    private Date m_date;
    private int m_heureDebut;
    private int m_heureFin;
    private int m_etat;
    private int m_idCours;
    private int m_idType;
    
    public Seance(int id, int semaine, Date date, int heureDebut, int heureFin
            ,int etat, int idCours, int idType) 
    {
        m_id = id;
        m_semaine = semaine;
        m_date = date;
        m_heureDebut = heureDebut;
        m_heureFin = heureFin;
        m_etat = etat;
        m_idCours = idCours;
        m_idType = idType;
    }
    
    public int getId(){return m_id;}
    
    public int getSemaine(){return m_semaine;}
    public Date getDate(){return m_date;}
    public int getHeureDebut(){return m_heureDebut;}
    public int getHeureFin(){return m_heureFin;}
    public int getEtat(){return m_etat;}
    public int getIdCours(){return m_idCours;}
    public int getIdType(){return m_idType;}

    
    public void setSemaine(int semaine){m_semaine=semaine;}
    public void setDate(Date date){m_date=date;}
    public void setHeureDebut(int heureDebut){m_heureDebut=heureDebut;}
    public void setHeureFin(int heureFin){m_heureFin=heureFin;}
    public void setEtat(int etat){m_etat=etat;}
    public void setIdCours(int idCours){m_idCours=idCours;}
    public void setIdType(int idType){m_idType=idType;}

}
