/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

import java.util.HashMap;
import java.util.PriorityQueue;

/** Solmuista, eli kohteista koostuva verkko.
 *
 * @author kaisa
 */
public class Verkko {
    
    PriorityQueue<Solmu> keko; //minimikeko
    HashMap<Solmu,HashMap<Solmu,Double>> vl; //vieruslista, jossa kaikki verkon solmut ja niiden naapurit
    
    /**
     * Parametritön konstruktori rakentaa satunnaisen verkon Helsingin alueen sijainneista.
     */
    public Verkko() {
        keko = new PriorityQueue();
    }
    
    public Verkko(String[] nimet, double[] leveyspiirit, double[] pituuspiirit) {
        vl = new HashMap();
        //if (nimet.length==leveyspiirit.length&&nimet.length==pituuspiirit.length) {
        //lisätään kaikki solmut vieruslistalle ja lasketaan etäisyydet solmusta solmuun
        //Huom. tämän O(n2);
        //huom testaa että taulukot yhtä isot!
        for(int i = 0; i < nimet.length; i++) {
            vl.put(new Solmu(nimet[i],i+1,leveyspiirit[i],pituuspiirit[i]),new HashMap());
      
            }
            
        }    
      
        

    
    
    public Verkko(HashMap verkko) { //luodaan verkko valmiilta vieruslistalta
        
    }
    
    /**
     * Metodi laskee etäisyyden kahden koordinaattipisteen välillä
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return etäisyys
     */
private static double laskeEtaisyys(double x1, double y1, double x2, double y2){
    double etaisyysX = Math.abs(x1 - x2);
    double etaisyysY = Math.abs(y1 - y2);
    double etaisyys = Math.sqrt( (etaisyysX*etaisyysX) + (etaisyysY*etaisyysY) );

    return etaisyys;
}
    
    
}
