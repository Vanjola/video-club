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
public class Zaposleni implements DomenskiObjekat{
    
    private int idZaposlenog;
    private String imeZaposlenog;
    private String prezimeZaposlenog;
    private String korisnickoIme;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(int idZaposlenog, String imeZaposlenog, String prezimeZaposlenog, String korisnickoIme, String lozinka) {
        this.idZaposlenog = idZaposlenog;
        this.imeZaposlenog = imeZaposlenog;
        this.prezimeZaposlenog = prezimeZaposlenog;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getIdZaposlenog() {
        return idZaposlenog;
    }

    public void setIdZaposlenog(int idZaposlenog) {
        this.idZaposlenog = idZaposlenog;
    }

    public String getImeZaposlenog() {
        return imeZaposlenog;
    }

    public void setImeZaposlenog(String imeZaposlenog) {
        this.imeZaposlenog = imeZaposlenog;
    }

    public String getPrezimeZaposlenog() {
        return prezimeZaposlenog;
    }

    public void setPrezimeZaposlenog(String prezimeZaposlenog) {
        this.prezimeZaposlenog = prezimeZaposlenog;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiKoloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
        List<DomenskiObjekat> list = new LinkedList<>();
        
        while(rs.next()){
            int idZaposlenog = rs.getInt("idZaposlenog");
            String imeZaposlenog=rs.getString("imeZaposlenog");
            String prezimeZaposlenog=rs.getString("prezimeZaposlenog");
            String korisnickoIme=rs.getString("korisnickoIme");
            String lozinka=rs.getString("lozinka");
            
            Zaposleni zaposleni= new Zaposleni(idZaposlenog, imeZaposlenog, prezimeZaposlenog, korisnickoIme, lozinka);
            list.add(zaposleni);
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "korisnickoIme = '" + korisnickoIme+"' AND lozinka = '" + lozinka+"'";
    }

    @Override
    public String toString() {
        return imeZaposlenog + " " + prezimeZaposlenog ;
    }
    
    
}
