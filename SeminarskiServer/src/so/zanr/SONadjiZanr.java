/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zanr;

import db.DbBroker;
import domen.Film;
import domen.Zanr;
import java.util.List;
import so.SistemskaOperacija;

/**
 *
 * @author vanja
 */
public class SONadjiZanr extends SistemskaOperacija {
    protected void validiraj(Object podatak) throws Exception {
        if(!(podatak instanceof Zanr)){
            throw new Exception("Prosledjeni objekat nije klase Zanr");
        }
       
    }

    @Override
    protected Object izvrsi(Object podatak) throws Exception {
        Zanr zanr = (Zanr) podatak;
        
        return (List<Zanr>)(List<?>) DbBroker.getInstanca().nadji(zanr);
    }
}
