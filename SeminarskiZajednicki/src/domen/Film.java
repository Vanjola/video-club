/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vanja
 */
public class Film implements DomenskiObjekat{
    private int idFilma;
    private String naziv;
    private int brojPrimeraka;
    private int godina;
    private String polica;
    private Zanr zanr;
    private Reziser reziser;

    public Film() {
    }

    public Film(int idFilma, String naziv, int brojPrimeraka, int godina, String polica, Zanr zanr, Reziser reziser) {
        this.idFilma = idFilma;
        this.naziv = naziv;
        this.brojPrimeraka = brojPrimeraka;
        this.godina = godina;
        this.polica = polica;
        this.zanr = zanr;
        this.reziser = reziser;
    }

    public int getIdFilma() {
        return idFilma;
    }

    public void setIdFilma(int idFilma) {
        this.idFilma = idFilma;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojPrimeraka() {
        return brojPrimeraka;
    }

    public void setBrojPrimeraka(int brojPrimeraka) {
        this.brojPrimeraka = brojPrimeraka;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getPolica() {
        return polica;
    }

    public void setPolica(String polica) {
        this.polica = polica;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Reziser getReziser() {
        return reziser;
    }

    public void setReziser(Reziser reziser) {
        this.reziser = reziser;
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
        final Film other = (Film) obj;
        return this.idFilma == other.idFilma;
    }

    @Override
    public String vratiNazivTabele() {
        return "film";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "naziv, brojPrimeraka, godina, polica, idZanra, idRezisera";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        // yyyy-MM-dd
        return "'"+naziv+"',"+brojPrimeraka+", "+godina+", '"+polica+"', "+ zanr.getIdZanra()+", " +reziser.getIdRezisera();
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        return true;
    }

    @Override
    public void setId(int generisaniId) {
        this.idFilma = generisaniId;
    }

    @Override
    public String vratiKoloneZaUpdate() {
        return " naziv ='"+naziv+"', brojPrimeraka="+brojPrimeraka+", godina="+godina+", polica='"+polica+"', idZanra="+zanr.getIdZanra()+", idRezisera="+reziser.getIdRezisera();
    }

    @Override
    public String vratiUslovZaId() {
        return "idFilma="+idFilma;
    }

    @Override
    public String vratiJoinUslov() {
        return "JOIN zanr ON film.idZanra = zanr.idZanra JOIN reziser on film.idRezisera = reziser.idRezisera";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception{
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
            
            list.add(film);
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "naziv like '%"+naziv+"%'";
    }

    @Override
    public String toString() {
        return naziv + " - " + reziser;
    }
    
    
}
