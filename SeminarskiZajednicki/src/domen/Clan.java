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
public class Clan implements DomenskiObjekat{
    
    private int idClana;
    private String ime;
    private String prezime;
    private String adresa;
    private String email;

    public Clan() {
    }

    public Clan(int idClana, String ime, String prezime, String adresa, String email) {
        this.idClana = idClana;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.email = email;
    }

    public int getIdClana() {
        return idClana;
    }

    public void setIdClana(int idClana) {
        this.idClana = idClana;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Clan other = (Clan) obj;
        return Objects.equals(this.email, other.email);
    }

    

    

    @Override
    public String vratiNazivTabele() {
        return "clan";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "ime, prezime, adresa, email";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+ime+"', '"+prezime+"', '"+adresa+"', '"+email+"'";
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        return true;
    }

    @Override
    public void setId(int generisaniId) {
        this.idClana=generisaniId;
    }

    @Override
    public String vratiKoloneZaUpdate() {
        return "ime='"+ime+"', prezime='"+prezime+"', email='"+email+"', adresa='"+adresa+"'";
    }

    @Override
    public String vratiUslovZaId() {
        return "idClana="+idClana;
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
        List<DomenskiObjekat> list=new LinkedList<>();
        while(rs.next()){
           int idClana=rs.getInt("idClana");
           String ime=rs.getString("ime");
           String prezime=rs.getString("prezime");
           String adresa=rs.getString("adresa");
           String email=rs.getString("email");
            
           Clan clan=new Clan(idClana, ime, prezime, adresa, email);
           
           list.add(clan);
            
            
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "CONCAT(ime, ' ', prezime) like '%"+ime+"%'";
    }
    
}
