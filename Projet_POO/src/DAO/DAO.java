/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;

/**
 *
 * @author Bauti
 */
public abstract class DAO<T> {
    protected Connection connect=null;
    
    public DAO(Connection conn){
        this.connect=conn;
    }
    
    public abstract boolean creer(T obj);
    
    public abstract boolean supprimer(T obj);
    
    public abstract boolean modifier(T obj);
    
    public abstract T trouver(int id);
}
