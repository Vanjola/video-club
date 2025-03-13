/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import db.DbBroker;
import domen.Rezervacija;
import domen.StavkaRezervacije;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SOIzmeniRezervaciju extends SistemskaOperacija{

    @Override
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Rezervacija)){
            throw new Exception("Prosledjeni objekat nije klase rezervacija");
        }
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Rezervacija rezervacija = (Rezervacija) podatak;
       
        List<StavkaRezervacije> listaStavkiIzBaze = (List<StavkaRezervacije>) (List<?>)DbBroker.getInstanca().nadji(new StavkaRezervacije(rezervacija, null));

        for(StavkaRezervacije stavkaIzBaze: listaStavkiIzBaze){
            if(!rezervacija.getStavke().contains(stavkaIzBaze)){
                DbBroker.getInstanca().obrisi(stavkaIzBaze);
            }
        }
        
        for(StavkaRezervacije novaStavka: rezervacija.getStavke()){
            if(!listaStavkiIzBaze.contains(novaStavka)){
                DbBroker.getInstanca().zapamti(novaStavka);
            }
        }
        
        DbBroker.getInstanca().izmeni(rezervacija);
        
        return rezervacija;
    }
    
}
