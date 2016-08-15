/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

import java.util.*;

/**
 * Solmuluokka, johon tallennetaan solmun koordinaatit
 *
 * @author kaisa
 */
public class Solmu {//implements Comparable{

    private String nimi;
    private int nro;
    private double x, y; //koordinaatit solmulle
    private double dist;
    private HashMap<Solmu, Double> naapurit;  //vieruslista johon merkitään naapurisolmut
    
    public Solmu(int nro, double y, double x) {
        this.nimi = this.toString();
        this.nro = nro;
        this.y=y;
        this.x=x;
        this.naapurit = new HashMap();
    }
    
    public Solmu(String nimi, int nro, double lev, double pit) {
        this.nimi = nimi;
        this.nro = nro;
        if (!this.setX(pit)) {
            this.x = 200;//-180-180, negatiiviset W, positiiviset E.
        }
        if (!this.setY(lev)) {
            this.y = 100;//-90-90, negatiiviset S, positiiviset N.
        }
        this.dist = Double.MAX_VALUE;   //alustetaan distance-arvoksi  maksimiarvo.

        this.naapurit = new HashMap();

    }

    public boolean setX(double pit) {
        if (pit <= 180.00 && pit >= -180.00) {
            this.x = pit;
            return true;
        } else {
            return false;
        }
    }

    public boolean setY(double lev) {
        if (lev <= 90 && lev >= -90) {
            this.x = lev;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean lisaaNaapuri(Solmu naapuri) {
        if (naapuri==null)
            return false;
        else {
        double etaisyys = Math.abs(this.x-naapuri.x)+Math.abs(this.y-naapuri.y);
        naapurit.put(naapuri, etaisyys);
        return true;
        }
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getDist() {
        return this.dist;
    }

    
    /** Vertailumetodi solmujen etäisyyksille. 
     * 
     * @param toinen solmu
     * @return -1, jos solmu on lähempänä tai yhtä lähellä, 1 jos kauempana kuin vertailtava solmu.
     */
    public int compareTo(Solmu toinen) {
        if (this.dist <= toinen.getDist()) {
            return -1;
        } else {
            return 1;
        }
    }

}
