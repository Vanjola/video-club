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
public class Reziser implements DomenskiObjekat {
    private int idRezisera;
    private String imeRezisera;
    private String prezimeRezisera;

    public Reziser() {
    }

    public Reziser(int idRezisera, String imeRezisera, String prezimeRezisera) {
        this.idRezisera = idRezisera;
        this.imeRezisera = imeRezisera;
        this.prezimeRezisera = prezimeRezisera;
    }

    public int getIdRezisera() {
        return idRezisera;
    }

    public void setIdRezisera(int idRezisera) {
        this.idRezisera = idRezisera;
    }

    public String getImeRezisera() {
        return imeRezisera;
    }

    public void setImeRezisera(String imeRezisera) {
        this.imeRezisera = imeRezisera;
    }

    public String getPrezimeRezisera() {
        return prezimeRezisera;
    }

    public void setPrezimeRezisera(String prezimeRezisera) {
        this.prezimeRezisera = prezimeRezisera;
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
        final Reziser other = (Reziser) obj;
        return this.idRezisera == other.idRezisera;
    }

    @Override
    public String toString() {
        return imeRezisera + " " + prezimeRezisera;
    }

    @Override
    public String vratiNazivTabele() {
        return "reziser";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "imeRezisera, prezimeRezisera";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+imeRezisera+"','"+prezimeRezisera+"'";
    }

    @Override
    public boolean imaAutoIncrementIdKolonu() {
        return true;
    }

    @Override
    public void setId(int generisaniId) {
        this.idRezisera=generisaniId;
    }

    @Override
    public String vratiKoloneZaUpdate() {
        return "imeRezisera='"+imeRezisera+"', prezimeRezisera='"+prezimeRezisera+"'";
    }

    @Override
    public String vratiUslovZaId() {
        return "idRezisera="+idRezisera;
    }

    @Override
    public String vratiJoinUslov() {
          return "";
    }

    @Override
    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception {
        List<DomenskiObjekat> list= new LinkedList<>();
        while(rs.next()){
            int idRezisera=rs.getInt("idRezisera");
            String imeRezisera=rs.getString("imeRezisera");
            String prezimeRezisera=rs.getString("prezimeRezisera");
            Reziser reziser= new Reziser(idRezisera, imeRezisera, prezimeRezisera);
            list.add(reziser);
        }
        return list;
    }

    @Override
    public String vratiUslovPretrage() {
        return "imeRezisera like '%"+imeRezisera+"%'";
    }
    
    
}
