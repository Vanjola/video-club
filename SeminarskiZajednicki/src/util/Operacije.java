/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

/**
 *
 * @author vanja
 */
public interface Operacije {
    
    public static final int LOGIN = 1;
    public static final int UCITAJ_LISTU_REZISERA=2;
    public static final int UCITAJ_LISTU_ZANROVA=3;
    public static final int UCITAJ_LISTU_FILMOVA=4;
    public static final int UCITAJ_LISTU_REZERVACIJA=5;
    public static final int UCITAJ_LISTU_CLANOVA=17;
    public static final int UCITAJ_STAVKE_REZERVACIJE = 18;
    
    public static final int NADJI_FILM=6;
    public static final int OBRISI_FILM=7;
    public static final int IZMENI_FILM=8;
    public static final int ZAPAMTI_FILM=16;
    
    public static final int NADJI_CLANOVE=9;
    public static final int ZAPAMTI_CLANA=10;
    public static final int OBRISI_CLANA=11;
    public static final int IZMENI_CLANA=12;
    
    
    public static final int NADJI_REZERVACIJE=13;
    public static final int IZMENI_REZERVACIJE=14;
    public static final int ZAPAMTI_REZERVACIJU=15;
    
    
    
    public static final int NADJI_ZANR=19;
    public static final int NADJI_REZERVACIJU=20;
}
