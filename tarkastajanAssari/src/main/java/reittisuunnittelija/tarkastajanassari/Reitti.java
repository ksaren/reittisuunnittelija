/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reittisuunnittelija.tarkastajanassari;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Yläluokka joka suorittaa reitin laskennan. Erilliset alaluokat lyhyimmälle
 * polulle A->B ja kaikkien solmujen läpikäymiseksi.
 *
 * Sisältää toistaiseksi Dijkstran simppelin version, jossa verkossa numeroidut
 * solmut.
 * Seuraavaksi:
 * -> Muutetaan A*-algoritmiksi (lisäämällä mm. etäisyysarvio maaliin)
 * -> Muutetaan käsittelemään monimutkaisempia syötteitä
 * -> Aloitetaan omien algoritmien toteutus
 *
 * @author kaisa
 */
public class Reitti {

    public Reitti() {

    }

    //yksinkertainen solmuluokka 
    public static class Node implements Comparable<Node> {

        int nro;
        int matka;

        public Node(int solmu, int paino) {
            nro = solmu;
            matka = paino;
        }

        @Override
        public int compareTo(Node toinen) {
            if (this.matka < toinen.matka) {
                return -1;
            } else {
                return 1;
            }

        }

        public int getNro() {
            return this.nro;
        }

        public void setNro(int nro) {
            this.nro = nro;
        }

        public int getMatka() {
            return this.matka;
        }

        public void setMatka(int m) {
            this.matka = m;
        }

        public String toString() {
            return this.nro + "," + this.matka;
        }

    }
    
    /**
     * Metodi toteuttaa A* heuristiikkafunktion laskemalla etäisyyden solmusta maaliin nk. Manhattan
     * -etäisyytenä, eli matkana x- ja y-koordinaattien etäisyyksien summana.
     * @param s
     * @param maali
     * @return 
     */
    public static double arvioiMatka(Solmu s,Solmu maali) {
        if(s==null||maali==null) {
            return 0;
        }
        else {
            return Math.abs(s.getX()-maali.getX())+Math.abs(s.getY()-maali.getY());
        }
    }
    
    public static boolean laskeJaAseta(Solmu s, Solmu maali) {
         if(s==null||maali==null) {
            return false;
         }
         else {
             return true;
         }
    }

    public static long lyhinReitti(int n, int[] mista, int[] minne, int[] hinta) {

        int[] kayty;
        HashMap<Integer, HashMap<Integer, Integer>> vl;
        PriorityQueue<Node> keko = new PriorityQueue();
        long matka = 0l;

        vl = new HashMap<Integer, HashMap<Integer, Integer>>();
        for (int i = 1; i < n + 1; i++) {
            vl.put(i, new HashMap<Integer, Integer>());    //alustetaan vieruslista 0-kaupungeilla
        }
        kayty = new int[n + 1];

        //rakennetaan vieruslista ja laitetaan samalla kaikki solmut kekoon
        HashMap<Integer, Integer> apuMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < mista.length; i++) {
            apuMap = vl.get(mista[i]);
            apuMap.put(minne[i], hinta[i]);
            vl.put(mista[i], apuMap);
        }
        for (int i = 0; i < minne.length; i++) {
            apuMap = vl.get(minne[i]);
            apuMap.put(mista[i], hinta[i]);
            vl.put(minne[i], apuMap);
        }
        System.out.println("vieruslista: " + vl.toString());
        keko.add(new Node(1, 0));
        Node s;
        while (!keko.isEmpty()) {
            System.out.println("Keko ei ole tyhjä, pollataan pienin\n" + keko.toString());
            s = keko.poll();
            apuMap = vl.get(s.getNro());
            System.out.println("Pollattiin " + s);
            if (kayty[s.getNro()]==0) {//jos ei ole merkitty käydyksi
                kayty[s.getNro()] = 1;//merkitään käydyksi
                matka += s.getMatka();
                System.out.println("kustannus solmussa " + s + "= " + matka);
                apuMap = vl.get(s.getNro());    //haetaan vieruslistalta tutkittavan solmun naapurit
                System.out.println("apumap " + apuMap);
                for (Integer kaup : apuMap.keySet()) {  //käydään naapurit läpi ja lisätään ne kekoon
                    System.out.println("Käsitellään kaupunkia " + kaup + ". vieruskaupungit kaupungille" + s.getNro() + ": " + apuMap);
                    keko.add(new Node(kaup, apuMap.get(kaup)));
                }
            }
        }

        return matka;
    }

    //Tira-pajasta kopsittuja testihakuja
    public static void main(String[] args) {
        System.out.println(lyhinReitti(3, new int[]{1, 2}, new int[]{2, 3}, new int[]{7, 4}));
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{2, 3, 3}, new int[]{7, 4, 5}));
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{2, 3, 3}, new int[]{2, 2, 2}));
    }
}
