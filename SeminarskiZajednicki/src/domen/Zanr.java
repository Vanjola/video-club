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
public class Zanr implements DomenskiObjekat {
    private int idZanra;
    private String nazivZanra;

    public Zanr() {
    }

    public Zanr(int idZanra, String nazivZanra) {
        this.idZanra = idZanra;
        this.nazivZanra = nazivZanra;
    }

    public int getIdZanra() {
        return idZanra;
    }

    public void setIdZanra(int idZanra) {
        this.idZanra = idZanra;
    }

    public String getNazivZanra() {
        return nazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    @Override
    public String toString() {
        return nazivZanra;
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
        final Zanr other = (Zanr) obj;
        return this.idZanra == other.idZanra;
    }

    @Override
    public String vratiNazivTabele() {
        return "zanr";
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
            return true;      
        }

    @Override
    public void setId(int generisaniId) {
        this.idZanra=generisaniId;
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
       return  ""; 
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
        List<DomenskiObjekat> list= new LinkedList<>();
        while(rs.next()){
            int idZanra=rs.getInt("idZanra");
            String nazivZanra=rs.getString("nazivZanra");
            Zanr zanr = new Zanr(idZanra, nazivZanra);
            list.add(zanr);
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "nazivZanra like '%"+nazivZanra+"%'";
    }
    
}
