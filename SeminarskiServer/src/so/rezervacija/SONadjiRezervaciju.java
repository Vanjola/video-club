/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import db.DbBroker;
import domen.Rezervacija;
import domen.Zanr;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SONadjiRezervaciju extends SistemskaOperacija{
     protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Rezervacija)){
            throw new Exception("Prosledjeni objekat nije klase Rezervacija");
        }
       
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Rezervacija Rezervacija = (Rezervacija) podatak;
        
        return (List<Rezervacija>)(List<?>) DbBroker.getInstanca().nadji(Rezervacija);
    }

}
