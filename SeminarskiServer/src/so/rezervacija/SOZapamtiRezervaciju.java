/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import db.DbBroker;
import domen.Film;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SOZapamtiRezervaciju extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Rezervacija)){
            throw new Exception("Prosledjeni objekat nije klase rezervacija");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Rezervacija rezervacija = (Rezervacija) podatak;
        
        DbBroker.getInstanca().zapamti(rezervacija);
        
        for(StavkaRezervacije stavkaRezervacije: rezervacija.getStavke()){
            stavkaRezervacije.setRezervacija(rezervacija);
            DbBroker.getInstanca().zapamti(stavkaRezervacije);
        }
        
        return rezervacija;
    }
    
}
