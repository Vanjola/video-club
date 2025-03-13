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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author vanja
 */
public class ClientController {
    private Socket socket;
    private Zaposleni ulogovani;
    private static ClientController instanca;
    
    private ClientController() throws Exception{
        socket = new Socket("localhost", 10000);
    }

    public static ClientController getInstanca() throws Exception{
        if(instanca == null){
            instanca = new ClientController();
        }
        return instanca;
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    public Zaposleni login(Zaposleni zaposleni) throws Exception{
        return (Zaposleni) posaljiZahtev(Operacije.LOGIN, zaposleni);
    }
    public List<Reziser> ucitajListuRezisera() throws Exception {
      return (List<Reziser>) posaljiZahtev(Operacije.UCITAJ_LISTU_REZISERA, null);
    } 
    public List<Zanr> ucitajListuZanrova() throws Exception{
        return (List<Zanr>) posaljiZahtev(Operacije.UCITAJ_LISTU_ZANROVA, null);
    }
     public List<Film> ucitajListuFilmova() throws Exception{
        return (List<Film>) posaljiZahtev(Operacije.UCITAJ_LISTU_FILMOVA, null);
    }
     public List<Rezervacija> ucitajListuRezervacija() throws Exception{
        return (List<Rezervacija>) posaljiZahtev(Operacije.UCITAJ_LISTU_REZERVACIJA, null);
    }
     public void obrisiFilm(Film film) throws Exception{
         posaljiZahtev(Operacije.OBRISI_FILM, film);
     }
     public List<Film> nadjiFilm( Film film) throws Exception{
         return (List<Film>)  posaljiZahtev(Operacije.NADJI_FILM, film);
     }
     public void zapamtiFilm(Film film) throws Exception{
         posaljiZahtev(Operacije.ZAPAMTI_FILM, film);
     }
     public void izmeniFilm(Film film) throws Exception{
         posaljiZahtev(Operacije.IZMENI_FILM, film);
     }
     public List<Clan> nadjiClanove(Clan clan) throws Exception{
         return (List<Clan>) posaljiZahtev(Operacije.NADJI_CLANOVE, clan);
     }
     public List<Zanr> nadjiZanr(Zanr zanr) throws Exception{
         return (List<Zanr>) posaljiZahtev(Operacije.NADJI_ZANR, zanr);
     }
     public List<Rezervacija> nadjiRezervaciju(Rezervacija rezervacija) throws Exception{
         return (List<Rezervacija>) posaljiZahtev(Operacije.NADJI_REZERVACIJU, rezervacija);
     }
     
      public void zapamtiClana(Clan clan) throws Exception{
         posaljiZahtev(Operacije.ZAPAMTI_CLANA, clan);
     }
       public void obrisiClana(Clan clan) throws Exception{
         posaljiZahtev(Operacije.OBRISI_CLANA, clan);
     }
       public void izmeniClana(Clan clan) throws Exception{
           posaljiZahtev(Operacije.IZMENI_CLANA, clan);
       }
       public List<Rezervacija> nadjiRezervacije(Rezervacija rezervacija) throws Exception{
         return (List<Rezervacija>) posaljiZahtev(Operacije.NADJI_REZERVACIJE, rezervacija);
     }
       public void izmeniRezervacije(Rezervacija rezervacija) throws Exception{
           posaljiZahtev(Operacije.IZMENI_REZERVACIJE, rezervacija);
       }
       public void zapamtiRezervaciju(Rezervacija rezervacija) throws Exception{
           posaljiZahtev(Operacije.ZAPAMTI_REZERVACIJU, rezervacija);
       }
     public List<Clan> ucitajListuClanova() throws Exception{
        return (List<Clan>) posaljiZahtev(Operacije.UCITAJ_LISTU_CLANOVA, null);
    }
     
     public Rezervacija ucitajStavkeRezervacije(Rezervacija rezervacija) throws Exception{
         return (Rezervacija) posaljiZahtev(Operacije.UCITAJ_STAVKE_REZERVACIJE, rezervacija);
     }
     
    private Object posaljiZahtev(int operacija, Object podatak) throws Exception{
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev(operacija, podatak);
        
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(klijentskiZahtev);
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ServerskiOdgovor serverskiOdgovor = (ServerskiOdgovor) in.readObject();
        
        if(serverskiOdgovor.getGreska() != null){
            throw serverskiOdgovor.getGreska();
        }
        
        return serverskiOdgovor.getPodatak();
    }
}
