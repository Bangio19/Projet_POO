/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet_POO;

/**
 *
 * @author Bauti
 */
public class Projet_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnect connect = new DBConnect();
        connect.getData();
        
        System.out.println("Hello");
    }
    
}
