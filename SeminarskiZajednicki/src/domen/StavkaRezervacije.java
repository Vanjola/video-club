/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vanja
 */
public class StavkaRezervacije implements DomenskiObjekat{
    private Rezervacija rezervacija;
    private Film film;

    public StavkaRezervacije() {
    }

    public StavkaRezervacije(Rezervacija rezervacija, Film film) {
        this.rezervacija = rezervacija;
        this.film = film;
    }
    

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRezervacije other = (StavkaRezervacije) obj;
        if (!Objects.equals(this.rezervacija, other.rezervacija)) {
            return false;
        }
        return Objects.equals(this.film, other.film);
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkarezervacije";
                
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "idRezervacije, idFilma";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return rezervacija.getIdRezervacije()+","+film.getIdFilma();
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        return false;
    }

    @Override
    public void setId(int generisaniId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiUslovZaId() {
        return "idRezervacije="+rezervacija.getIdRezervacije()+" AND idFilma="+film.getIdFilma();
    }

    @Override
    public String vratiJoinUslov() {
        return "JOIN film ON stavkarezervacije.idFilma = film.idFilma JOIN reziser ON film.idRezisera = reziser.idRezisera JOIN zanr ON film.idZanra = zanr.idZanra";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
          List<DomenskiObjekat> list = new LinkedList<>();
        while(rs.next()){
            int idZanra = rs.getInt("idZanra");
            String nazivZanra = rs.getString("nazivZanra");
            Zanr zanr = new Zanr(idZanra, nazivZanra);
            
            int idRezisera = rs.getInt("idRezisera");
            String imeRezisera = rs.getString("imeRezisera");
            String prezimeRezisera = rs.getString("prezimeRezisera");
            Reziser reziser = new Reziser(idRezisera, imeRezisera, prezimeRezisera);
            
            int idFilma = rs.getInt("idFilma");
            String naziv = rs.getString("naziv");
            int brojPrimeraka = rs.getInt("brojPrimeraka");
            int godina = rs.getInt("godina");
            String polica = rs.getString("polica");
            
            Film film = new Film(idFilma, naziv, brojPrimeraka, godina, polica, zanr, reziser);
           
           StavkaRezervacije stavkaRezervacije=new StavkaRezervacije(rezervacija, film);
            list.add(stavkaRezervacije);
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "idRezervacije = " + rezervacija.getIdRezervacije();
    }
    
}
