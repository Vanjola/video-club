/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkarezervacije;

import db.DbBroker;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SOPretraziStavkeRezervacije extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Rezervacija)){
            throw new Exception("Prosledjeni objekat nije klase Rezervacija");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Rezervacija rezervacija = (Rezervacija) podatak;
        
        List<StavkaRezervacije> listaStavki = (List<StavkaRezervacije>) (List<?>)DbBroker.getInstanca().nadji(new StavkaRezervacije(rezervacija, null));
        
        rezervacija.setStavke(listaStavki);
        
        return rezervacija;
    }
    
}
