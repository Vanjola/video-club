/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vanja
 */
public class Rezervacija implements DomenskiObjekat {

    private int idRezervacije;
    private Date datumRezervacije;
    private boolean statusRezervacije;
    private Clan clan;
    private Zaposleni zaposleni;
    private List<StavkaRezervacije> stavke;

    public Rezervacija() {
    }

    public Rezervacija(int idRezervacije, Date datumRezervacije, boolean statusRezervacije, Clan clan, Zaposleni zaposleni, List<StavkaRezervacije> stavke) {
        this.idRezervacije = idRezervacije;
        this.datumRezervacije = datumRezervacije;
        this.statusRezervacije = statusRezervacije;
        this.clan = clan;
        this.zaposleni = zaposleni;
        this.stavke = stavke;
    }

    public int getIdRezervacije() {
        return idRezervacije;
    }

    public void setIdRezervacije(int idRezervacije) {
        this.idRezervacije = idRezervacije;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public boolean isStatusRezervacije() {
        return statusRezervacije;
    }

    public void setStatusRezervacije(boolean statusRezervacije) {
        this.statusRezervacije = statusRezervacije;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public List<StavkaRezervacije> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRezervacije> stavke) {
        this.stavke = stavke;
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
        final Rezervacija other = (Rezervacija) obj;
        return this.idRezervacije == other.idRezervacije;
    }

    @Override
    public String vratiNazivTabele() {
        return "rezervacija";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "datumRezervacije,statusRezervacije,idClana,idZaposlenog";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "'" + sdf.format(datumRezervacije) + "'," + statusRezervacije + ", " + clan.getIdClana() + ", " + zaposleni.getIdZaposlenog();
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        return true;
    }

    @Override
    public void setId(int generisaniId) {
        this.idRezervacije = generisaniId;
    }

    @Override
    public String vratiKoloneZaUpdate() {
        return "statusRezervacije=" + statusRezervacije + ", idClana=" + clan.getIdClana() + ", idZaposlenog=" + zaposleni.getIdZaposlenog();
    }

    @Override
    public String vratiUslovZaId() {
        return "idRezervacije= " + idRezervacije;
    }

    @Override
    public String vratiJoinUslov() {
        return "JOIN clan ON rezervacija.idClana=clan.idClana JOIN zaposleni ON zaposleni.idZaposlenog=rezervacija.idZaposlenog";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
        List<DomenskiObjekat> list = new LinkedList<>();
        while(rs.next()){
            int idClana = rs.getInt("idClana");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String adresa = rs.getString("adresa");
            String email = rs.getString("email");
           
            Clan clan =new Clan(idClana, ime, prezime, adresa, email);
            
            int zaposleniId = rs.getInt("idZaposlenog");
            String imeZaposlenog = rs.getString("imeZaposlenog");
            String prezimeZaposlenog = rs.getString("prezimeZaposlenog");
            String korisnickoIme = rs.getString("korisnickoIme");
            String lozinka  = rs.getString("lozinka");
            Zaposleni zaposleni=new Zaposleni(zaposleniId, imeZaposlenog, prezimeZaposlenog, korisnickoIme, lozinka);
            
            int idRez=rs.getInt("idRezervacije");
            java.sql.Date datumSQL=rs.getDate("datumRezervacije");
            Date datumUtil=new Date(datumSQL.getTime());
            boolean statusRezervacije=rs.getBoolean("statusRezervacije");
            
            Rezervacija rezervacija=new Rezervacija(idRez,datumUtil, statusRezervacije, clan, zaposleni, new LinkedList<>());
            list.add(rezervacija);

        }
        return list;

    }

    @Override
    public String vratiUslovPretrage() {
        return "CONCAT(ime, ' ', prezime) like '%"+clan.getIme()+"%'";
    }

}
