/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

/**Linjaluokka sisältää taulukon Solmuja eli pysäkkejä.
 *
 * @author kaisa
 */
public class Linja {
    
    Solmu[] linja;
    String tunnus;
    
    public Linja(String tunnus, int pysakkeja) {
        this.linja = new Solmu[pysakkeja+1];
        this.tunnus = tunnus;
        for (int i=1; i<=pysakkeja; i++){
            
        }
            
    }
    
   
    public boolean lisaaSolmu(Solmu s) {
        return true;
    }
}
