/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

/**
 *
 * @author kaisa
 */
public class Main {
    
    public static void main(String[] args) {
        Verkko v = new Verkko(new String[]{"A","B","C"},new double[]{59.5,60.0,61.5},new double[]{23.5,24.2,25.0});
        System.out.println("Testi:");
        System.out.println("Syötteenä pieni taulukko, sijainnit A, B ja C:");
        System.out.println(v);
        
    }
    
}
