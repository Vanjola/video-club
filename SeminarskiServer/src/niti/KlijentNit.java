/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.ServerController;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.KlijentskiZahtev;
import util.Operacije;
import util.ServerskiOdgovor;

/**
 *
 * @author vanja
 */
public class KlijentNit extends Thread{
    
    private Socket socket;

    public KlijentNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            while(true){
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                
                KlijentskiZahtev klijentskiZahtev = (KlijentskiZahtev)in.readObject();
                
                ServerskiOdgovor serverskiOdgovor = obradiZahtev(klijentskiZahtev);
                
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(serverskiOdgovor);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev klijentskiZahtev) {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();
        try{
            switch(klijentskiZahtev.getOperacija()){
                case Operacije.LOGIN:
                    Zaposleni z = (Zaposleni) klijentskiZahtev.getPodatak();
                    
                    Zaposleni ulogovani = ServerController.getInstanca().login(z);
                    serverskiOdgovor.setPodatak(ulogovani);
                    break;
                case Operacije.UCITAJ_LISTU_REZISERA:
                    List<Reziser> listaSvihRezisera = ServerController.getInstanca().ucitajListuRezisera();
                    serverskiOdgovor.setPodatak(listaSvihRezisera);
                    break;
                case Operacije.UCITAJ_LISTU_ZANROVA:
                    List<Zanr> listaSvihZanrova= ServerController.getInstanca().ucitajListuZanrova();
                    serverskiOdgovor.setPodatak(listaSvihZanrova);
                    break;
                case Operacije.UCITAJ_LISTU_FILMOVA:
                    List<Film> listaSvihFilmova= ServerController.getInstanca().ucitajListuFilmova();
                    serverskiOdgovor.setPodatak(listaSvihFilmova);
                    break;
                case Operacije.UCITAJ_LISTU_REZERVACIJA:
                    List<Rezervacija> listaSvihRezervacija=ServerController.getInstanca().ucitajListuRezervacija();
                    serverskiOdgovor.setPodatak(listaSvihRezervacija);
                    break;
                case Operacije.OBRISI_FILM:
                    Film filmZaBrisanje=(Film) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().obrisiFilm(filmZaBrisanje);
                    break;
                case Operacije.NADJI_FILM:
                    Film filmZaTraznje=(Film) klijentskiZahtev.getPodatak();
                    List<Film> nadjeniFilmovi=ServerController.getInstanca().nadjiFilm(filmZaTraznje);
                    serverskiOdgovor.setPodatak(nadjeniFilmovi);
                    break;
                case Operacije.IZMENI_FILM:
                    Film filmZaMenjanje= (Film) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().izmeniFilm(filmZaMenjanje);
                    break;
                case Operacije.NADJI_CLANOVE:
                    Clan clanZaTrazenje=(Clan) klijentskiZahtev.getPodatak();
                    List<Clan> nadjeniClanovi=ServerController.getInstanca().nadjiClanove(clanZaTrazenje);
                    serverskiOdgovor.setPodatak(nadjeniClanovi);
                    break;
                case Operacije.ZAPAMTI_CLANA:
                    Clan clanZaPamcenje=(Clan) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().zapamtiClana(clanZaPamcenje);
                    break;
                case Operacije.IZMENI_CLANA:
                    Clan clanZaMenjanje= (Clan) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().izmeniClana(clanZaMenjanje);
                    break;
                case Operacije.OBRISI_CLANA:
                    Clan clanZaBrisanje= (Clan) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().obrisiClana(clanZaBrisanje);
                    break;
                case Operacije.NADJI_REZERVACIJE:
                    Rezervacija rezervacijaZaTrazenje=(Rezervacija) klijentskiZahtev.getPodatak();
                    List<Rezervacija> nadjeneRezervacije=ServerController.getInstanca().nadjiRezervacije(rezervacijaZaTrazenje);
                    serverskiOdgovor.setPodatak(nadjeneRezervacije);
                    break;
                case Operacije.IZMENI_REZERVACIJE:
                    Rezervacija rezervacijaZaIzmenu=(Rezervacija) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().izmeniRezervacije(rezervacijaZaIzmenu);
                    break;
                case Operacije.ZAPAMTI_REZERVACIJU:
                    Rezervacija rezervacijaZaPamcenje=(Rezervacija) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().zapamtiRezervaciju(rezervacijaZaPamcenje);
                    break;
                case Operacije.ZAPAMTI_FILM:
                    Film filmZaPamcenje= (Film) klijentskiZahtev.getPodatak();
                    ServerController.getInstanca().zapamtiFilm(filmZaPamcenje);
                    break;
                case Operacije.UCITAJ_LISTU_CLANOVA:
                    List<Clan> listaSvihClanova= ServerController.getInstanca().ucitajListuClanova();
                    serverskiOdgovor.setPodatak(listaSvihClanova);
                    break;
                case Operacije.UCITAJ_STAVKE_REZERVACIJE:
                    Rezervacija rezervacija = (Rezervacija) klijentskiZahtev.getPodatak();
                    Rezervacija ucitanaRezervacija = ServerController.getInstanca().ucitajStavkeRezervacije(rezervacija);
                    serverskiOdgovor.setPodatak(ucitanaRezervacija);
                    break;
            }
        }catch(Exception ex){
            ex.printStackTrace();
            serverskiOdgovor.setGreska(ex);
        }
        return serverskiOdgovor;
    }

    void ugasiKlijenta() {
        try {
            socket.close();
        } catch (IOException ex) {
        }
    }
    
    
}
