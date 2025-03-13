/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Clan;
import domen.Film;
import domen.Rezervacija;
import domen.Reziser;
import domen.Zanr;
import domen.Zaposleni;
import java.util.List;
import so.SistemskaOperacija;
import so.clan.SOIzmeniClana;
import so.clan.SONadjiClana;
import so.clan.SOObrisiClana;
import so.clan.SOUcitajListuClanova;
import so.clan.SOZapamtiClana;
import so.film.SOIzmeniFilm;
import so.film.SONadjiFilmove;
import so.film.SOObrisiFilm;
import so.film.SOUcitajListuFilmova;
import so.film.SOZapamtiFilm;
import so.rezervacija.SOIzmeniRezervaciju;
import so.rezervacija.SONadjiRezervaciju;
import so.rezervacija.SOUcitajListuRezervacija;
import so.rezervacija.SOZapamtiRezervaciju;
import so.reziser.SOUcitajListuRezisera;
import so.stavkarezervacije.SOPretraziStavkeRezervacije;
import so.zanr.SONadjiZanr;
import so.zanr.SOUcitajListuZanrova;
import so.zaposleni.SOLogin;

/**
 *
 * @author vanja
 */
public class ServerController {
    
    private static ServerController instanca;
    
    private ServerController(){
        
    }

    public static ServerController getInstanca() {
        if(instanca == null){
             instanca= new ServerController();
        }
        return instanca;
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        SistemskaOperacija so= new SOLogin();
        return (Zaposleni) so.izvrsiOperaciju(z);
    }

    public List<Reziser> ucitajListuRezisera() throws Exception {
        SistemskaOperacija so = new SOUcitajListuRezisera();
        return (List<Reziser>) so.izvrsiOperaciju(null);
    }

    public List<Zanr> ucitajListuZanrova() throws Exception {
        SistemskaOperacija so = new SOUcitajListuZanrova();
     return (List<Zanr>) so.izvrsiOperaciju(null);
    }

    public List<Film> ucitajListuFilmova() throws Exception{
        SistemskaOperacija so = new SOUcitajListuFilmova();
        
        return (List<Film>)so.izvrsiOperaciju(null);
    }

    public List<Rezervacija> ucitajListuRezervacija() throws Exception {
        SistemskaOperacija so= new SOUcitajListuRezervacija();
        return (List<Rezervacija>) so.izvrsiOperaciju(null);

    }

    

    public void obrisiFilm(Film filmZaBrisanje) throws Exception {
        SistemskaOperacija so = new SOObrisiFilm();
        so.izvrsiOperaciju(filmZaBrisanje);
    }

    public List<Film> nadjiFilm(Film filmZaTraznje) throws Exception {
        SistemskaOperacija so = new SONadjiFilmove();
        
        return (List<Film>)so.izvrsiOperaciju(filmZaTraznje);
    }

    public void zapamtiFilm(Film filmZaPamcenje) throws Exception {
        SistemskaOperacija so = new SOZapamtiFilm();
        so.izvrsiOperaciju(filmZaPamcenje);
    }

    public void izmeniFilm(Film filmZaMenjanje) throws Exception {
        SistemskaOperacija so = new SOIzmeniFilm();
        so.izvrsiOperaciju(filmZaMenjanje);
    }

    public List<Clan> nadjiClanove(Clan clanZaTrazenje) throws Exception {
        SistemskaOperacija so= new SONadjiClana();
        return  (List<Clan>) so.izvrsiOperaciju(clanZaTrazenje);
    }
    
    public List<Zanr> nadjiZanr(Zanr zanrZaTrazenje) throws Exception{
        SistemskaOperacija so= new SONadjiZanr();
        return (List<Zanr>) so.izvrsiOperaciju(zanrZaTrazenje);
    }
     public List<Rezervacija> nadjiRezervaciju(Rezervacija rezervacijaZaTrazenje) throws Exception{
        SistemskaOperacija so= new SONadjiRezervaciju();
        return (List<Rezervacija>) so.izvrsiOperaciju(rezervacijaZaTrazenje);
    }
    

    public void zapamtiClana(Clan clanZaPamcenje) throws Exception {
        SistemskaOperacija so =new SOZapamtiClana();
        so.izvrsiOperaciju(clanZaPamcenje);
    }

    public void izmeniClana(Clan clanZaMenjanje) throws Exception {
        SistemskaOperacija so = new SOIzmeniClana();
        so.izvrsiOperaciju(clanZaMenjanje);
    }

    public void obrisiClana(Clan clanZaBrisanje) throws Exception {
        SistemskaOperacija so=new  SOObrisiClana();
        so.izvrsiOperaciju(clanZaBrisanje);
    }

    public List<Rezervacija> nadjiRezervacije(Rezervacija rezervacijaZaTrazenje) throws Exception {
        SistemskaOperacija so = new SONadjiRezervaciju();
        return (List<Rezervacija>)so.izvrsiOperaciju(rezervacijaZaTrazenje);
    }

    public void izmeniRezervacije(Rezervacija rezervacijaZaIzmenu) throws Exception {
        SistemskaOperacija so = new SOIzmeniRezervaciju();
        so.izvrsiOperaciju(rezervacijaZaIzmenu);
    }

    public void zapamtiRezervaciju(Rezervacija rezervacijaZaPamcenje) throws Exception {
        SistemskaOperacija so = new SOZapamtiRezervaciju();
        so.izvrsiOperaciju(rezervacijaZaPamcenje);
    }

    public List<Clan> ucitajListuClanova() throws Exception {
        SistemskaOperacija so = new SOUcitajListuClanova();
        return (List<Clan>) so.izvrsiOperaciju(null);
            
    }

    public Rezervacija ucitajStavkeRezervacije(Rezervacija rezervacija) throws Exception {
        SistemskaOperacija so = new SOPretraziStavkeRezervacije();
        return (Rezervacija) so.izvrsiOperaciju(rezervacija);
    }

   
    
    
}
