/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author vanja
 */
public interface DomenskiObjekat extends Serializable{

    public String vratiNazivTabele();

    public String vratiKoloneZaInsert();

    public String vratiVrednostiZaInsert();

    public boolean imaAutoIncrementIdKolonu();

    public void setId(int generisaniId);

    public String vratiKoloneZaUpdate();

    public String vratiUslovZaId();

    public String vratiJoinUslov();

    public List<DomenskiObjekat> napraviListu(ResultSet rs) throws Exception;

    public String vratiUslovPretrage();
    
}
